/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Copyright ©2016-2023 Gary F. Pollice
 *******************************************************************************/
package escape.builder;

import escape.board.EscapePieceImpl;
import escape.board.coordinates.LocationType;
import escape.board.EscapePiece.*;
import escape.board.coordinates.Location;

/**
 * A general initializer for a board location. Since this is used
 * internally and not part of the game, we take a shortcut and make
 * the instance variables public rather than private since this class
 * is not part of the actual game implementation.
 * <p>
 * This file mirrors the <locationInitializers> structure in the
 * XML configuration files.
 * <p>
 * You do not have to use this, but are encouraged to do so.
 * <p>
 * However, you do need to be able to load the appropriate named
 * data from the configuration file in order to create a game
 * correctly.
 * <p>
 * MODIFIABLE: YES
 * MOVEABLE: NO
 * REQUIRED: NO
 */
public class LocationInitializer {
    public int x, y;
    public LocationType locationType;

    public String player;
    public PieceTypeDescriptor pieceTypeDescriptor;

    public PieceName pieceName;

    public LocationInitializer() {
        // needed for JAXB unmarshalling
    }

    public LocationInitializer(int x, int y, LocationType locationType,
                               String player) {
        this.x = x;
        this.y = y;
        this.locationType = locationType;
        this.player = player;
        this.pieceTypeDescriptor = null;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LocationInitializer [x=" + x + ", y=" + y + ", locationType="
                + locationType + ", player=" + player + ", pieceName=" + pieceName + "]";
    }

    /**
     * Creates location to use with escapeBoard
     *
     * @return location
     */
    public Location createLocation() {
        //create piece first
        if (this.pieceTypeDescriptor == null) {
            return new Location(this.x, this.y, this.locationType);
        }
        EscapePieceImpl piece = new EscapePieceImpl(this.pieceName, this.player, this.pieceTypeDescriptor.getAttributes(), this.pieceTypeDescriptor.getDistance(), this.pieceTypeDescriptor.getMovementPattern());
        return new Location(this.x, this.y, this.locationType, this.player, piece);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public PieceName getPieceName() {
        return this.pieceName;
    }


    public void addPieceDescriptor(PieceTypeDescriptor descriptor) {
    this.pieceTypeDescriptor = descriptor;
    }
}