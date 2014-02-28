/*
 * Copyright © 2013 Marc Gagné <gagne.marc@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 *
 */

import org.jsfml.graphics.*;
import org.jsfml.system.*;
import org.jsfml.window.*;
import org.jsfml.window.event.*;

class Screen {
    
    private RenderWindow fWindow;

    private Player fPlayer;
    
    public Screen(RenderWindow window)
    {
        fWindow = window;
        Vector2i size = window.getSize();
        Vector2f playerPosition = new Vector2f(
            (float) (size.x/2 - 13),
            (float) (size.y - 80));
        fPlayer = new Player(this, "Player 1", playerPosition);
    }
    
    public void processEvent(Event event)
    {
    }
    
    public void update(Time delta)
    {
        // Move the player.
        if (Keyboard.isKeyPressed(Keyboard.Key.LEFT))
            fPlayer.movePlayer(-delta.asSeconds() * fPlayer.SPEED);
        else if (Keyboard.isKeyPressed(Keyboard.Key.RIGHT))
            fPlayer.movePlayer(delta.asSeconds() * fPlayer.SPEED);
        fWindow.draw(fPlayer);
    }

    public Vector2i getSize()
    {
        return fWindow.getSize();
    }
    
}
