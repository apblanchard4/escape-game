package escape.board.validator;

import escape.board.EscapeBoard;
import escape.board.MoveValidator;
import escape.required.Coordinate;
import escape.required.EscapeException;

/**
 * Checks if the move is a valid request
 * Focused solely on to/from coordinates themselves and player
 */

public class MoveValidatorHex implements MoveValidator
{
    public boolean validateMove(EscapeBoard board, Coordinate from, Coordinate to, String player) {

        if (!validCoordinates(board, from, to)) {
            return false;
        }
        if (!board.getPieceAt(from).getPlayer().equals(player)) {
            return false;
        }
        return true;
    }
    public boolean validCoordinates(EscapeBoard board, Coordinate from, Coordinate to) {
        if (board.getLocationAt(from) == null)
            return false;

        boolean validX = false;
        boolean validY = false;
        if (board.getXMax() == 0 || (Math.abs(to.getRow()) <= board.getXMax() && Math.abs(from.getRow()) <= board.getXMax())) {
            validX = true;
        }
//check y
        if (board.getYMax() == 0 || (Math.abs(to.getColumn()) <= board.getYMax() && Math.abs(from.getColumn()) <= board.getYMax())) {
            validY = true;
        }
        return validX && validY;

    }
}
