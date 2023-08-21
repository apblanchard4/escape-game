/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright ©2023 Gary F. Pollice
 *******************************************************************************/
package escape.required;

/**
 * Implements the Game Status Interface
 *
 */
public class GameStatusImpl implements GameStatus {

    private GameStatus.MoveResult moveResult;
    private CombatResult combatResult;

    private Coordinate currentCoordinate;
    private boolean isValidMove;
    private int pointsGained;

    /**
     * default constructor
     */
    public GameStatusImpl() {
        this.moveResult = GameStatus.MoveResult.LOSE;
        this.combatResult = CombatResult.NONE;
        this.currentCoordinate = null;
        this.isValidMove = false;

    }
    public GameStatusImpl(Coordinate from) {
        this.moveResult = GameStatus.MoveResult.NONE;
        this.combatResult = CombatResult.NONE;
        this.currentCoordinate = from;
        this.isValidMove = true;

    }
    public GameStatusImpl(Coordinate from, int pointsGained) {
        this.moveResult = GameStatus.MoveResult.NONE;
        this.combatResult = CombatResult.NONE;
        this.currentCoordinate = from;
        this.isValidMove = true;
        this.pointsGained = pointsGained;

    }

    /**
     * WIN:  Player that moved wins the game
     * LOSE: Player that moved loses the game
     * DRAW: The game is over and is a draw
     * NONE: The game is still in progress and neither player has won
     */
    public static enum MoveResult { WIN, LOSE, DRAW, NONE }

    /**
     * ATTACKER: The player that moved attacked another piece and won
     * DEFENDER: The defending piece won the battle
     * DRAW:     The battle was a draw
     * NONE:     There was no battle
     */
    public static enum CombatResult { ATTACKER, DEFENDER, DRAW, NONE }

    /**
     * @return true if the move was a valid move, fals if not (an exception may have
     * been thown in some cases)
     */


    @Override
    public boolean isValidMove() {
        return this.isValidMove;
    }
    /**
     * @return true if more informaton was sent to the objservers
     */

    public boolean isMoreInformation() {
        return false;
    }

    /**
     * @return an indicator if the game ended and the state of win/loss
     */
    public GameStatus.MoveResult getMoveResult() {
        return this.moveResult;
    }

    /**
     * @return the location of the moving piece after the move if it is different
     * the destination (to) specified in the move();
     */
    public Coordinate finalLocation() {
        return this.currentCoordinate;
    }

    public int getPointsGained() {
        return pointsGained;
    }


    public void setMoveResult(GameStatus.MoveResult moveResult) {
        this.moveResult = moveResult;
    }
    public void setFinalLocation( ) {
        this.currentCoordinate = null;
    }
}
