/*
 * Copyright © 2013 Marc Gagné <gagne.marc@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 *
 */

class Player extends Entity {
    
    public static double SPEED = 5.0;
    private static String SPRITE_FILE = "res/player.png";

    private String fName;
    
    public Player(String name)
    {
        super(SPRITE_FILE);
        fName = name;
        fHealth = 500.0;
    }

    public void movePlayer(float deltaX)
    {
    }
}
