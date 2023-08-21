package escape.board.validator;

import escape.board.EscapeBoard;
import escape.board.EscapePiece;
import escape.board.EscapePieceImpl;
import escape.board.coordinates.CoordinateImpl;
import escape.board.coordinates.Location;
import escape.board.coordinates.LocationType;
import escape.required.Coordinate;
import escape.required.EscapeException;

import java.util.LinkedList;
import java.util.Queue;

public class PathFinderHex implements PathFinder {
    EscapeBoard board;
    PathFinderHex(EscapeBoard board) {
        this.board = board;
    }

    /**
     * BFS algorithm to find path
     *
     * @param piece
     * @param from
     * @param to
     * @return true if path exists
     */
    public boolean findPath(EscapePieceImpl piece, Coordinate from, Coordinate to) {
        int distance = piece.getDistance();
        Queue<CoordinateImpl> q = new LinkedList<>();
        CoordinateImpl fromImpl = (CoordinateImpl) from;
        fromImpl.setDepth(0);
        q.add(fromImpl);
        while (q.size() > 0) {

            CoordinateImpl c = q.peek();
            if (c.getDepth() >= distance) {
                return false;
            }
            q.remove();

            if (c.equals(to)) {
                if (!openCoordinate(true, piece, to)) {
                    return false;
                }
                return true;
            }
            Queue<Coordinate> adj = getAdjacent(c, piece);
            while (adj.size() > 0) {
                //check each adj
                CoordinateImpl next = (CoordinateImpl) adj.poll();
                next.setDepth(c.getDepth()+1);
                if (next.equals(to)) {
                    if (!openCoordinate(true, piece, to)) {
                        return false;
                    }
                    return true;
                }

                else {
                    if (openCoordinate(false, piece, next))
                    q.add(next);
                }

            }

        }
        return false;
    }

    public boolean findPathSingleDirection(EscapePieceImpl piece, Coordinate from, Coordinate to) {
        int[] direction = getLinearDirection(to, from);
        int distance = piece.getDistance();
        int currentDistance = 0;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(from);
        while (q.size() > 0) {
            Coordinate c = (q.peek());
            q.remove();
            if (currentDistance == distance) {
                return false;
            }
            if (c.equals(to)) {
                if (!openCoordinate(true, piece, to)) {
                    return false;
                }
                return true;
            }
            //check other directions
            currentDistance++;

            Coordinate next = new CoordinateImpl(c.getRow() + direction[0], c.getColumn() + direction[1]);
            if (next.equals(to) && openCoordinate(true, piece, to)) {
                return true;
            }
            if (openCoordinate(false, piece, next)) {
                q.add(next);
            }
        }
        return false;
    }

    public int[][] getDirections(EscapePiece.MovementPattern movementPattern) {
        DirectionFinder directionFinder = new DirectionFinder(Coordinate.CoordinateType.HEX, movementPattern);
        return directionFinder.getDirections(Coordinate.CoordinateType.HEX, movementPattern);
    }

    public boolean openCoordinate(Boolean last, EscapePieceImpl piece, Coordinate coordinate) {
        Location location = this.board.getLocationAt(coordinate);
        if (location == null) {
            return true;
        }
        if (last) return location.canMoveFinal(piece);
        return location.canMove(piece);
    }

    public int[] getLinearDirection(Coordinate to, Coordinate from) {
        int[] direction = new int[2];
        int rowDifference = to.getRow() - from.getRow();
        int columnDifference = to.getColumn() - from.getColumn();
        return new int[]{rowDifference,columnDifference};
    }

    public Queue<Coordinate> getAdjacent(Coordinate coordinate, EscapePieceImpl piece) {
            Queue<Coordinate> adj = new LinkedList<>();
            int[][] directions = getDirections(piece.getMovementPattern());
            for (int[] direction : directions) {
                Coordinate next = new CoordinateImpl(coordinate.getRow() + direction[0], coordinate.getColumn() + direction[1]);

                adj.add(next);
            }
            return adj;
    }


}
