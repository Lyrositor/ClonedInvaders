/*
 * Copyright © 2013 Marc Gagné <gagne.marc@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 *
 */

import java.io.*;
import java.nio.file.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;

class Entity extends Sprite {

    protected boolean fDeleted;
    protected double fHealth;

    protected Screen fScreen;

    public Entity(Screen screen, String textureFilename)
    {
        super();
        fDeleted = false;
        fScreen = screen;
        try {
            Image textureImage = new Image();
            textureImage.loadFromFile(Paths.get(textureFilename));
            Texture texture = new Texture();
            texture.loadFromImage(textureImage);
            setTexture(texture);
        } catch (IOException|TextureCreationException ex) {
            System.err.println("Failed to create player texture:");
            ex.printStackTrace();
        }
        fHealth = 100.0;
    }

    public boolean isDeleted()
    {
        return fDeleted;
    }

    public void update(Time delta)
    {
    }

}
