package escape;

import escape.board.EscapeBoard;
import escape.board.EscapePiece;
import escape.board.coordinates.CoordinateImpl;
import escape.builder.EscapeGameBuilder;
import escape.required.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameBlockTests {

    //test creating game builder with configuration file

    @Test
    void addBlockToBuild() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board = null;
        EscapePiece piece = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare3Unblock.egc").makeGameManager();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(escapeManager);
    }

    @Test
    void squareMoveThroughBlock() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare3Unblock.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(2, 4), new CoordinateImpl(1, 4));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 5), new CoordinateImpl(4, 5));
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        //assertEquals(gameStatus.isValidMove(), false);
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.LOSE);

    }
    @Test
    void hexMoveThroughBlock() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex3Unblock.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        //assertEquals(gameStatus.isValidMove(), false);
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.LOSE);

    }
    @Test
    void squareMoveLandBlock() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare3Unblock.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 1));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        //assertEquals(gameStatus.isValidMove(), false);
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.LOSE);

    }
    @Test
    void hexMoveLandBlock() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex3Unblock.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(0, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        //assertEquals(gameStatus.isValidMove(), false);
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.LOSE);

    }
    @Test
    void squareMoveThroughBlockUnblock() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare3Unblock.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
        //assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.LOSE);

    }
    @Test
    void hexMoveThroughBlockUnblock() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex3Unblock.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, -1));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);

    }
}



