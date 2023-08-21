package escape;

import escape.board.EscapeBoard;
import escape.board.EscapePiece;
import escape.board.coordinates.CoordinateImpl;
import escape.builder.EscapeGameBuilder;
import escape.required.GameStatus;
import escape.required.GameStatusImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameNoRulesEndOfGame {
    @Test
    void makeBoardTestPieces() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;
        int pieces = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            pieces = escapeManager.getPlayers()[0].getPieces();


        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(pieces, 3);
    }

    @Test
    void squareCheckPiecesRemoval() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;
        int pieces = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/basicEndTestSquare.egc").makeGameManager();
            escapeManager.move(new CoordinateImpl(1,1), new CoordinateImpl(2,2));
            pieces = escapeManager.getPlayers()[0].getPieces();


        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(pieces, 2);
    }
    @Test
    void hexCheckPiecesRemoval() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;
        int piecesBefore = -1;
        int piecesAfter = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/hextest1.egc").makeGameManager();
            piecesBefore = escapeManager.getPlayers()[0].getPieces();
            escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));

            piecesAfter = escapeManager.getPlayers()[0].getPieces();


        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(piecesBefore -1, piecesAfter);
    }


    @Test
    void squareAllPiecesExitP1() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;
        GameStatus gameStatus;
        int pieces = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/basicEndTestSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(5, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(3, 4));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(5, 2), new CoordinateImpl(4, 3));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 4), new CoordinateImpl(3, 4));
            pieces= escapeManager.getPlayers()[0].getPieces();
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(pieces, 0);
    }
    @Test
    void hexAllPiecesExitP2() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus;
        EscapeBoard board= null;

        int piecesAfter = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/basicEndTestHex.egc").makeGameManager();

            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(0, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(0, -2), new CoordinateImpl(1, -2));

            piecesAfter = escapeManager.getPlayers()[1].getPieces();


        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(0, piecesAfter);
    }

    @Test
    void squareRemovedGameStatus() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;
        GameStatus gameStatus= null;
        int pieces = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/basicEndTestSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(5, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(3, 4));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(5, 2), new CoordinateImpl(4, 3));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 4), new CoordinateImpl(3, 4));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);
    }
    @Test
    void hexRemovedGameStatus() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus=null;
        EscapeBoard board= null;

        int piecesAfter = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/basicEndTestHex.egc").makeGameManager();

            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(0, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(0, -2), new CoordinateImpl(1, -2));


        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);
    }

    @Test
    void hexRemovedTryAnotherMove() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus=null;
        EscapeBoard board= null;

        int piecesAfter = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/basicEndTestHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(0, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(0, -2), new CoordinateImpl(1, -2));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 0), new CoordinateImpl(3, 0));

        } catch (Exception e) {
            assertEquals( e.getMessage(), "This game is over, start a new one" );
        }
    }
    @Test
    void squareInvalidEnd() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus=null;
        EscapeBoard board= null;

        int piecesAfter = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(9, 13), new CoordinateImpl(11, 12));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 4), new CoordinateImpl(4, 5));

        } catch (Exception e) {
            assertEquals( e.getMessage(), "This game is over, start a new one" );
        }
    }

    @Test
    void hexInvalidEnd() {
        EscapeGameManagerImpl escapeManager = null;
        GameStatus gameStatus=null;
        EscapeBoard board= null;

        int piecesAfter = -1;
        PlayerInfo[] playerInfo;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/basicEndTestHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 0));
            gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(0, 0));

        } catch (Exception e) {
            assertEquals( e.getMessage(), "This game is over, start a new one" );
        }
    }
}




