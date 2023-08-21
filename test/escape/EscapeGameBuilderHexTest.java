package escape;

import escape.board.coordinates.CoordinateImpl;
import escape.board.EscapePiece;
import escape.builder.EscapeGameBuilder;
import escape.required.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameBuilderHexTest {

    @Test
    void makeHexBoard() {
        EscapeGameManager escapeManager = null;

        try {
            escapeManager = new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }

        assertNotNull(escapeManager);
    }
    @Test
    void makeInfHexBoard() {
        EscapeGameManager escapeManager = null;

        try {
            escapeManager = new EscapeGameBuilder("./test/configurations/infhextest.egc").makeGameManager();
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }

        assertNotNull(escapeManager);
    }

    @Test
    void moveOmni() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2,2 ));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }
    @Test
    void moveOmniInfiniteBoard() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/infhextest.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-4,0 ));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }


    @Test
    void moveOmniNoPiece() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(0, 0), new CoordinateImpl(-4,0 ));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }
    @Test
    void moveOmniPieceAtLocation() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0,-2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }
    @Test
    void moveOmniOffBoard() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-4,0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void moveOmniPastDistance() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0,1));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void moveLinear() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(0,1));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }


    @Test
    void moveLinearInfiniteBoard() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/infhextest.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(0,1));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void moveLinearTooFar() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3,0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void moveSameToAndFrom() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }


    @Test
    void movePieceAtToSamePlayer() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, -2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }
}




