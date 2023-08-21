package escape.board.validator;

import escape.board.EscapeBoard;
import escape.board.EscapePiece;
import escape.board.EscapePieceImpl;
import escape.board.coordinates.Location;
import escape.required.Coordinate;
import escape.required.EscapeException;

public interface PathFinder {

    public EscapeBoard board = null;


    boolean findPathSingleDirection(EscapePieceImpl movingPiece, Coordinate from, Coordinate to);

    boolean findPath(EscapePieceImpl movingPiece, Coordinate from, Coordinate to);

    //boolean anyValidMoves(EscapeBoard board, Location from );


}

