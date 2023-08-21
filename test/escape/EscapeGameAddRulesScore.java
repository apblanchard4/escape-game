package escape;

import escape.board.coordinates.CoordinateImpl;
import escape.board.EscapeBoard;
import escape.board.EscapePiece;
import escape.builder.EscapeGameBuilder;
import escape.required.GameStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameAddRulesScore {
    @Test
    void addScoreRule() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/squareScoreTest.egc").makeGameManager();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(escapeManager);
    }
    @Test
    void squareScore1() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;
        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterSquare2.egc").makeGameManager();
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
    void hexScore1() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex2.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);

    }
    @Test
    void hexScore3() {
        EscapeGameManagerImpl escapeManager = null;
        EscapePiece piece = null;
        GameStatus gameStatus = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/masterHex.egc").makeGameManager();
            gameStatus = escapeManager.move(new CoordinateImpl(-2, 0), new CoordinateImpl(0, 0));
          //  gameStatus = escapeManager.move(new CoordinateImpl(1, 3), new CoordinateImpl(2, 2));

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(gameStatus.getMoveResult(), GameStatus.MoveResult.WIN);

    }

}




