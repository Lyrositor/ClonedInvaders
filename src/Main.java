/*
 * Copyright © 2013 Marc Gagné <gagne.marc@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 *
 */

import org.jsfml.graphics.*;
import org.jsfml.graphics.Color.*;
import org.jsfml.system.*;
import org.jsfml.window.*;
import org.jsfml.window.event.*;

import ClonedInvaders.*;

public class Main {

    private static String TITLE = "Cloned Invaders";

    /**
     *  Runs the main game loop.
     */
    public static void main(String args[]) {
        
        // Prepare the main window.
        RenderWindow window = new RenderWindow();
        window.create(new VideoMode(800, 600), TITLE);

        // Create our only screen (the game screen) and a clock to keep
        // track of the time which has passed between two update cycles.
        Screen screen = new Screen(window);
        Clock clock = new Clock();
        Time delta;

        // Main game loop.
        while (window.isOpen()) {
            // Process new events.
            for (Event event : window.pollEvents()) {
                if(event.type == Event.Type.CLOSED) {
                    window.close();
                }
            }
            
            // Clear the window.
            window.clear(Color.BLACK);
            
            // Update the screen's elements.
            delta = clock.restart();
            screen.update(delta);
            
            // Display everything.
            window.display();

        }

    }

}
