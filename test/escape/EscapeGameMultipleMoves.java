package escape;

import escape.board.coordinates.CoordinateImpl;
import escape.board.EscapePiece;
import escape.builder.EscapeGameBuilder;
import escape.required.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameMultipleMoves {

    //test creating game builder with configuration file

    @Test
    void square2InRow() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(4, 3));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void square2InRow2ndIntoFirst() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(1, 1));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void square3Moves() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(1, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(4, 3));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void square2MovesSamePlayer() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 4), new CoordinateImpl(5, 4));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }
    @Test
    void square2Moves2ndIntoFirstLocation() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(3, 3));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void hex2InRow() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(-1, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void hex2InRow2ndIntoFirst() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(0, -2), new CoordinateImpl(-2, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void hex3Moves() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(0, -2), new CoordinateImpl(-2, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 2), new CoordinateImpl(0, 2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void hex2MovesSamePlayer() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 2), new CoordinateImpl(0, 2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }
    @Test
    void hex2Moves2ndIntoFirstLocation() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(-2, 2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }


}



