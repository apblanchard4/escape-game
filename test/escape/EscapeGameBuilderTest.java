package escape;

import escape.board.*;
import escape.board.coordinates.CoordinateImpl;
import escape.board.coordinates.Location;
import escape.builder.*;
import escape.required.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameBuilderTest {

    //test creating game builder with configuration file
    @Test
    void createBuilder() {
        EscapeGameBuilder escapeGameBuilder = null;

        try {
            escapeGameBuilder = new EscapeGameBuilder("./test/configurations/test1.egc");
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(escapeGameBuilder);
    }
    @Test
    void makeGameObject() {
        EscapeGameManager escapeManager = null;

        try {
            escapeManager = new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }

        assertNotNull(escapeManager);
    }
    @Test
    void makeCoordinateTest() {
        EscapeGameManager escapeManager = null;
        Coordinate coordinate = null;
        try {
            escapeManager =  new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            coordinate = escapeManager.makeCoordinate(2, 2);
        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(coordinate);
    }
    @Test
    void makeCoordinateGetRow() {
        EscapeGameManager escapeManager = null;
        Coordinate coordinate = null;
        int row = 0;
        try {
            escapeManager =  new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            coordinate = escapeManager.makeCoordinate(1, 2);
            row = coordinate.getRow();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertEquals(row, 1);
    }
    @Test
    void makeCoordinateOffBoard() throws Exception {
        EscapeGameManager escapeManager=  new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
        Coordinate c = escapeManager.makeCoordinate(-2, 5000);
        assertEquals(-2, c.getRow());
        assertEquals(5000, c.getColumn());

    }
    @Test
    void makeCoordinateGetRowOutsideOfBounds() {
        EscapeGameManager escapeManager = null;
        Coordinate coordinate = null;

        try {
            escapeManager =  new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            coordinate = escapeManager.makeCoordinate(10, 20);

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(coordinate);
    }

    @Test
    void makeBoardNoLocations() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            board = escapeManager.getEscapeBoard();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(board);
    }

    @Test
    void makeBoardOneClear() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;
        Location location = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1.egc").makeGameManager();
            board = escapeManager.getEscapeBoard();
            location = board.getLocationAt(new CoordinateImpl(4,4));


        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(location);
    }

    @Test
    void makeBoardNoType() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;
        Location location = null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test2.egc").makeGameManager();
            board = escapeManager.getEscapeBoard();
            location = board.getLocationAt(new CoordinateImpl(8,15));


        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(location);
    }
    @Test
    void makeBoardInf() {
        EscapeGameManagerImpl escapeManager = null;
        EscapeBoard board= null;

        try {
            escapeManager = (EscapeGameManagerImpl) new EscapeGameBuilder("./test/configurations/test1-2.egc").makeGameManager();
            board = escapeManager.getEscapeBoard();

        } catch (Exception e) {
            fail("Exception from builder " + e.getMessage());
        }
        assertNotNull(board);
    }

}



