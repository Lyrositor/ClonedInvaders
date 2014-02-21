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
        fPlayer = new Player("Player 1");
    }
    
    public void processEvent(Event event)
    {
    }
    
    public void update(Time delta)
    {
        fWindow.draw(fPlayer);
    }
    
}
