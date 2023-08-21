package escape.board;

import escape.required.Coordinate;
import escape.required.EscapeException;

/**
 * Checks if the move is a valid request
 * Focused solely on to/from coordinates themselves and player
 */

public interface MoveValidator
{
    public boolean validateMove(EscapeBoard board, Coordinate from, Coordinate to, String player);
    public boolean validCoordinates(EscapeBoard board, Coordinate from, Coordinate to);
    }

