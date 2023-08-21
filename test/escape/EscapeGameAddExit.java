package escape;

import escape.board.coordinates.CoordinateImpl;
import escape.board.EscapePiece;
import escape.builder.EscapeGameBuilder;
import escape.required.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameAddExit {

    //test creating game builder with configuration file

    @Test
    void addExit() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;


        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(escapeManager);
    }

    @Test
    void squarePassExit() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(2, 4), new CoordinateImpl(5, 4));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void squarePassExitWithFly() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(5, 5));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }


    @Test
    void hexPassExit() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(0, -2), new CoordinateImpl(2, -2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), false);
    }

    @Test
    void hexPassExitWithFly() {
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
    void squarePassExitFinalLocation() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }
    @Test
    void squarePassExitFinalLocationCheckPoints() {
        EscapeGameManagerImpl escapeManager = null;
        PlayerInfo[] playerInfo = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 2));
            playerInfo = escapeManager.getPlayers();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(playerInfo[0].getScore(), 3);

    }
    @Test
    void hexPassExitFinalLocation() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.isValidMove(), true);
    }
    @Test
    void hexPassExitFinalLocationCheckPoints() {
        EscapeGameManagerImpl escapeManager = null;
        PlayerInfo[] playerInfo = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));
            playerInfo = escapeManager.getPlayers();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(playerInfo[0].getScore(), 1);
        assertNull(escapeManager.getPieceAt(new CoordinateImpl(2,2)));
    }
    @Test
    void hexPassExitFinalLocationCheckPointsLinear() {
        EscapeGameManagerImpl escapeManager = null;
        PlayerInfo[] playerInfo = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(0, 0));
            playerInfo = escapeManager.getPlayers();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }

        assertEquals(playerInfo[1].getScore(), 1);
        assertNull(escapeManager.getPieceAt(new CoordinateImpl(0,0)));
    }

    @Test
    void squarePassExitFinalLocationCheckPointsLinear() {
        EscapeGameManagerImpl escapeManager = null;
        PlayerInfo[] playerInfo = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(2, 4), new CoordinateImpl(2, 2));
            playerInfo = escapeManager.getPlayers();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(playerInfo[0].getScore(), 1);
        assertNull(escapeManager.getPieceAt(new CoordinateImpl(2,2)));
    }
}



