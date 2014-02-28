/*
 * Copyright © 2013 Marc Gagné <gagne.marc@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 *
 */

import org.jsfml.graphics.*;
import org.jsfml.system.*;

class Player extends Entity {
    
    public static double SPEED = 600.0;
    private static String SPRITE_FILE = "res/player.png";

    private String fName;
    
    public Player(Screen screen, String name, Vector2f position)
    {
        super(screen, SPRITE_FILE);
        fName = name;
        fHealth = 500.0;
        setPosition(position);
    }

    public void movePlayer(double deltaX)
    {
        float newX = getPosition().x + (float) deltaX;
        Vector2i size = fScreen.getSize();
        FloatRect bounds = getGlobalBounds();
        if (newX + bounds.width <= size.x && newX >= 0)
            setPosition(newX, (float) getPosition().y);
    }
}
