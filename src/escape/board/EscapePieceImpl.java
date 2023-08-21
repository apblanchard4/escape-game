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

package escape.board;

import escape.builder.PieceAttribute;

import java.util.Arrays;
import java.util.Optional;

/**
 * Interface for the piece implementations. It also contains static
 * enumerations for the piece names, movement patterns, and attributes since
 * these are properties of pieces. How you implement the actual piece implementations
 * is up to you and the design decisions you make.
 * <p>
 * MODIFIABLE: NO
 * MOVEABLE: YES
 * REQUIRED: YES
 * <p>
 * You may extend this interface for your internal use, but this is the public interface
 * that all clients will use.
 */
public class EscapePieceImpl implements EscapePiece {
    private PieceName pieceName;
    private String player;
    private int value;

    private PieceAttribute[] attributes;
    private int distance;
    private MovementPattern movementPattern;


    public EscapePieceImpl (PieceName pieceName, String player, PieceAttribute[] pieceAttribute, int distance, MovementPattern movementPattern) {
        this.pieceName=pieceName;
        this.player = player;
        this.attributes = pieceAttribute;
        this.distance = distance;
        this.movementPattern = movementPattern;
        setValue();
    }

    /**
     * @return the name
     */
    public PieceName getName() {
        return pieceName;
    }

    /**
     * @return the owning player
     */
    public String getPlayer() {
        return player;
    }

    public PieceAttribute[] getPieceAttribute(PieceAttributeID value) {
        return this.attributes;
    }

    public int getDistance() {
        return this.distance;
    }
    public PieceAttribute getAttribute(PieceAttributeID id)
    {
        Optional<PieceAttribute> attr =
                Arrays.stream(attributes)
                        .filter(a -> a.getId().equals(id))
                        .findFirst();
        return attr.isPresent() ? attr.get() : null;
    }
    public MovementPattern getMovementPattern() {
        return this.movementPattern;
    }
    public void setValue() {
        PieceAttribute attribute = getAttribute(PieceAttributeID.VALUE);
        if (attribute!= null)
        this.value = attribute.getValue();
        else this.value= 1;
    }
    public int getValue() {
       return this.value;
    }
}
