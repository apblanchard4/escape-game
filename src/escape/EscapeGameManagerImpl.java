package escape;

import escape.board.*;
import escape.board.coordinates.CoordinateImpl;
import escape.builder.LocationInitializer;
import escape.required.Rule.RuleID;
import escape.required.*;
import escape.required.Coordinate.CoordinateType;

import java.util.Map;

/**
 * EscapeGameManagerImpl
 */
public class EscapeGameManagerImpl<C extends Coordinate> implements EscapeGameManager {
    boolean activeGame = true;
    EscapeBoard escapeBoard;

    PlayerInfo[] players;
    int xMax, yMax;
    int turn = 0;
    private RuleManager ruleManager;


    /**
     * Returns a coordinate of the appropriate type. If the coordinate cannot be
     * created, then null is returned and the status message is set appropriately.
     *
     * @param x the x component
     * @param y the y component
     * @return the coordinate or null if the coordinate cannot be implemented
     */
    @Override
    public Coordinate makeCoordinate(int x, int y) {
        //check if inside of max area
        Coordinate c = new CoordinateImpl(x, y);
        return c;

    }

    /**
     * Escape Board Setter
     *
     * @param type type of coordinates used in the board
     * @param xMax
     * @param yMax
     */
    public void setEscapeBoard(CoordinateType type, int xMax, int yMax, LocationInitializer[] locationInitializer) {
        this.xMax = xMax;
        this.yMax = yMax;
        this.escapeBoard = new EscapeBoard(type, xMax, yMax, locationInitializer);
    }

    public void setRules(Map<RuleID, Rule> ruleDescriptorMap) {
        this.ruleManager = new RuleManager(ruleDescriptorMap);
    }

    /**
     * Getter
     *
     * @return escape board
     */
    public EscapeBoard getEscapeBoard() {
        return this.escapeBoard;
    }


    /**
     * Setter for players
     *
     * @param players String of players in the game
     */
    public void setPlayers(PlayerInfo[] players) {
        this.players = players;
    }

    /**
     * Getter for player
     *
     * @return String array of players
     */
    public PlayerInfo[] getPlayers() {
        return this.players;
    }

    /**
     * Make the move in the current game.
     *
     * @param from starting location
     * @param to   ending location
     * @return true if the move was legal, false otherwise
     */
    @Override
    public GameStatus move(Coordinate from, Coordinate to) {
        if (activeGame) {
            GameStatusImpl gameStatus = this.escapeBoard.move(this.players[turn % 2].getName(), from, to);
            updateManagerPostMove(gameStatus);
            return gameStatus;
        } else
            throw new EscapeException("This game is over, start a new one");
    }

    /**
     * Gets piece at the coordinate
     *
     * @param coordinate the location to probe
     * @return escapePiece
     */
    public EscapePiece getPieceAt(Coordinate coordinate) {
        EscapePiece escapePiece = this.escapeBoard.getPieceAt(coordinate);
        return escapePiece;
    }

    public GameStatusImpl updateManagerPostMove(GameStatusImpl gameStatus) {
        if (gameStatus.isValidMove() == true) {
            //use game status to check on if the game is ended
            if (gameStatus.getPointsGained() != 0) {
                this.players[turn % 2].removePiece(gameStatus.getPointsGained());
                gameStatus.setFinalLocation();
            }
            this.turn++;

            if (ruleManager.checkGameEnd(this)) {
                this.activeGame = false;
                gameStatus.setMoveResult(ruleManager.getMoveResult(this.players, (this.turn+1)%2));

            }
        }
        else {
            this.activeGame = false; }

//|| this.escapeBoard.anyValidMoves(this.players[turn%2].getName())

        return gameStatus;
    }

}


