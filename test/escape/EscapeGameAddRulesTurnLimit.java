package escape;

import escape.board.coordinates.CoordinateImpl;
import escape.board.EscapePiece;
import escape.builder.EscapeGameBuilder;
import escape.required.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameAddRulesTurnLimit {

    @Test
    void addTurnLimit() {
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
    void SquareturnLimitTryMoveAfter() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(5, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(5, 5));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 5), new CoordinateImpl(4, 5));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 1), new CoordinateImpl(4, 2));
        } catch (Exception e) {
            assertEquals(e.getMessage(),"This game is over, start a new one" );
        }

    }
    @Test
    void HexturnLimitTryMoveAfter() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(1, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(4, 3));

        } catch (Exception e) {
            assertEquals(e.getMessage(),"This game is over, start a new one" );
        }

    }

    @Test
    void squareNoPointsAddedTie() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(5, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(5, 5));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 5), new CoordinateImpl(4, 5));
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.DRAW);
    }

    @Test
    void hexNoPointsAddedTie() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {

            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(0, -2), new CoordinateImpl(-2, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.DRAW);
    }


    @Test
    void squareP1ExitWin() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(2, 4), new CoordinateImpl(2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(5, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(5, 5));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 5), new CoordinateImpl(4, 5));
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.LOSE);
    }
    @Test
    void hexP1ExitWin() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {

            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);
    }
    @Test
    void squareP2ExitWin() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(5, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(5, 5));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(2, 2));
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);
    }
    @Test
    void hexP2ExitWin() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {

            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(-2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(0, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);
    }
    @Test
    void squareBothExitDraw() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(3, 1));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(5, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(4, 4));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(2, 2));
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.DRAW);
    }

    @Test
    void hexBothExitDraw() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {

            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));
           // gameStatus = escapeManager.move(new CoordinateImpl(0, -2), new CoordinateImpl(1, -2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);
    }

    @Test
    void squareBothExitDifferentValues() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(2, 4), new CoordinateImpl(1, 4));
            gameStatus = escapeManager.move(new CoordinateImpl(2, 5), new CoordinateImpl(4, 5));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(2, 2));
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.LOSE);
    }

    @Test
    void hexBothExitDifferentValues() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {

            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));
          //  gameStatus = escapeManager.move(new CoordinateImpl(-1, 1), new CoordinateImpl(0, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);
    }

    @Test
    void squareMultipleExits() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(1, 1), new CoordinateImpl(2, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(4, 1), new CoordinateImpl(5, 2));
            gameStatus = escapeManager.move(new CoordinateImpl(3, 3), new CoordinateImpl(4, 4));
            gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(2, 2));
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.LOSE);
    }
}




