package escape;

import escape.board.*;
import escape.board.coordinates.CoordinateImpl;
import escape.builder.EscapeGameBuilder;
import org.junit.jupiter.api.Test;
import escape.required.GameStatus;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameMoveTest {

    //test creating game builder with configuration file

    @Test
    void moveUpOne() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board = null;
        EscapePiece piece = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            escapeManager.move(new CoordinateImpl(8, 15), new CoordinateImpl(8, 16));
            piece = escapeManager.getPieceAt(new CoordinateImpl(8, 16));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(piece);
    }

    @Test
    void moveUpPieceinOtherLocation() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(8, 13), new CoordinateImpl(8, 15));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);


    }

    @Test
    void moveUpNoPieceAtFrom() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(8, 14), new CoordinateImpl(8, 15));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void movePieceNotOwned() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus =  escapeManager.move(new CoordinateImpl(4, 4), new CoordinateImpl(4, 5));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);


    }

    @Test
    void moveOmni() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus =  escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 3));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);


    }

    @Test
    void moveOmniCheckDistance() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(8, 13), new CoordinateImpl(8, 14));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void moveOmniNotEnoughDistance() {
            EscapeGameManagerImpl escapeManager = null;
            EscapePiece piece = null;
            GameStatus gameStatus =null;

            try {
                escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
                gameStatus = escapeManager.move(new CoordinateImpl(8, 13), new CoordinateImpl(24, 14));
            } catch (Exception e) {
                fail("Exception from builder " + e.getMessage());
            }
            assertEquals(gameStatus.isValidMove(), false);

    }

    @Test
    void moveOrthogonal() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(10, 13), new CoordinateImpl(11, 13));
            piece = escapeManager.getPieceAt(new CoordinateImpl(11, 13));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void moveOrthogonalTooFar() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus =  escapeManager.move(new CoordinateImpl(10, 16), new CoordinateImpl(9, 10));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);




    }

    @Test
    void moveLinear() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(9, 13), new CoordinateImpl(9, 14));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void moveLinearInvalid() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(9, 13), new CoordinateImpl(11, 12));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void movePieceInWay() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(7, 13), new CoordinateImpl(10, 13));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void movePieceInWayFly() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(7, 16), new CoordinateImpl(7, 14));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }

    @Test
    void moveDiagonal() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 3));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }
    @Test
    void moveDiagonalMultipleDirections() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(1, 3));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }
    @Test
    void moveDiagonalTooFar() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus =null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 4));

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
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(4, 4), new CoordinateImpl(4, 4));

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
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(4, 4), new CoordinateImpl(4, 3));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

}



