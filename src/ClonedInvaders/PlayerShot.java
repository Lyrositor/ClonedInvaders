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

class PlayerShot extends Shot {

    public static double SPEED = 200.0;
    private static String SPRITE_FILE = "res/missile.png";

    public PlayerShot(Screen screen, Player player)
    {
        super(screen, SPRITE_FILE);
        float startX = player.getPosition().x + player.getGlobalBounds().width/2;
        float startY = player.getPosition().y - 10;
        setPosition(startX, startY);
    }

    public void update(Time delta)
    {
        moveShot(-delta.asSeconds() * SPEED);
    }

    public void moveShot(double deltaY)
    {
        float newY = getPosition().y + (float) deltaY;
        Vector2i size = fScreen.getSize();
        FloatRect bounds = getGlobalBounds();
        if (newY > -10)
            setPosition((float) getPosition().x, newY);
        else
            fDeleted = true;
    }

}
