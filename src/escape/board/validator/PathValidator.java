package escape.board.validator;

import escape.board.EscapeBoard;
import escape.board.EscapePiece.MovementPattern;
import escape.board.EscapePieceImpl;
import escape.board.coordinates.Location;
import escape.board.validator.PathFinder;
import escape.board.validator.PathFinderHex;
import escape.board.validator.PathFinderSquare;
import escape.required.Coordinate;


/**
 * Class used to check the board to see if the path is valid
 */
public class PathValidator {
//pass the piece, need to check the rules of the piece
    //path finder may need to get neighboring pieces


    public Boolean isValidPath(EscapeBoard board, Coordinate from, Coordinate to) {
        EscapePieceImpl movingPiece = (EscapePieceImpl) board.getLocationAt(from).getPiece();
        PathFinder pathFinder =getPathFinder(board);

        if (movingPiece.getMovementPattern().equals(MovementPattern.LINEAR)) {
            return pathFinder.findPathSingleDirection(movingPiece, from, to);
        }

        return pathFinder.findPath(movingPiece, from, to);

    }

  /*  public boolean anyValidMoves(EscapeBoard board, String player) {
        PathFinder pathFinder =getPathFinder(board);
        for (Location location : board.getCoordinates().values()) {

            if (location.getPlayer() != null && location.getPlayer().equals(player));
            if (pathFinder.anyValidMoves(board, location)) return true;
        }
        return false; }
        */


    public PathFinder getPathFinder(EscapeBoard board) {
        PathFinder pathFinder =null;
        if (board.getCoordinateType().equals(Coordinate.CoordinateType.HEX)) {
            pathFinder = new PathFinderHex(board);
        }
        else {
            pathFinder = new PathFinderSquare(board);
        }
        return pathFinder;
    }
}

