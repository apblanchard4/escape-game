package escape.board.validator;

import escape.board.EscapeBoard;
import escape.board.MoveValidator;
import escape.required.Coordinate;


/**
 * Checks if the move is a valid request
 * Focused solely on to/from coordinates themselves and player
 */

public class MoveValidatorSquare implements MoveValidator
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
        if (board.getLocationAt(from) == null || to.getColumn() <= 0 || to.getRow() <= 0)
            return false;

        //check x
        if (board.getXMax() == 0 || (to.getRow() <= board.getXMax() && from.getRow() <= board.getXMax())) {
                return true;
            }
//check y
        if (board.getYMax() == 0 || (to.getColumn() <= board.getYMax() && from.getColumn() <= board.getYMax())) {
            return true;
        }
        return false;

    }
}
