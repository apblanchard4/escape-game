/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright ©2016-2023 Gary F. Pollice
 *******************************************************************************/

package escape.required;

/**
 * The interface for a client to use to get messages from the
 * game manager by registering an observer.
 * 
 * MODIFIABLE: NO
 * MOVEABLE: YES
 * REQUIRED: YES
 * 
 * You may extend this interface for your internal use, but this is the public interface
 * that all clients will use.
 */
public class GameObserverImpl implements GameObserver
{
    /**
     * Receive a message from the game
     * @param message
     */
    public void notify(String message)
    {
    	throw new EscapeException("Not implemented");
    }
    
    
    /**
     * Receive a message with the cause
     * @param message
     * @param cause usually the exception that caused the state indicated
     * 	by the message
     */
    public void notify(String message, Throwable cause)
    {
    	throw new EscapeException("Not implemented");
    }
}
