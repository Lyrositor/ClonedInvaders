/*
 * Copyright © 2013 Marc Gagné <gagne.marc@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 *
 */

import java.util.*;

import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.*;
import org.jsfml.window.event.*;

class Screen {
    
    private RenderWindow fWindow;

    private ArrayList<Entity> fEntities;
    private Player fPlayer;
    private boolean isShooting;
    
    public Screen(RenderWindow window)
    {
        fEntities = new ArrayList<Entity>();
        fWindow = window;
        Vector2i size = window.getSize();
        Vector2f playerPosition = new Vector2f(
            (float) (size.x/2 - 13),
            (float) (size.y - 80));
        fPlayer = new Player(this, "Player 1", playerPosition);
        addEntity(fPlayer);
        isShooting = false;
    }

    public void addEntity(Entity entity)
    {
        fEntities.add(entity);
    }

    public void processEvent(Event event)
    {
        KeyEvent keyEvent;
        switch (event.type)
        {
            case KEY_PRESSED:
                keyEvent = event.asKeyEvent();

                // Send any shots which were fired.
                if (keyEvent.key == Keyboard.Key.SPACE)
                {
                    if (!isShooting)
                    {
                        isShooting = true;
                        fPlayer.shoot();
                    }
                }
                break;
            case KEY_RELEASED:
                keyEvent = event.asKeyEvent();

                if (keyEvent.key == Keyboard.Key.SPACE)
                    if (isShooting)
                        isShooting = false;
                break;
        }
    }
    
    public void update(Time delta)
    {
        ArrayList<Entity> toDelete = new ArrayList<Entity>();

        // Update and draw all entities.
        for (Iterator<Entity> i = fEntities.iterator(); i.hasNext();)
        {
            Entity entity = i.next();
            entity.update(delta);
            if (!entity.isDeleted())
                fWindow.draw(entity);
            else
                toDelete.add(entity);
        }

        // Delete entities which should be destroyed.
        for (Iterator<Entity> i = toDelete.iterator(); i.hasNext();)
            fEntities.remove(i.next());
    }

    public Vector2i getSize()
    {
        return fWindow.getSize();
    }
    
}
