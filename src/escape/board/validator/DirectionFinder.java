package escape.board.validator;

import escape.board.EscapePiece;
import escape.required.Coordinate;
import escape.required.Coordinate.CoordinateType;

import java.util.HashMap;
import java.util.Map;

public class DirectionFinder {

    private Map<EscapePiece.MovementPattern, int[][]> directionMapSquare;
    private Map<EscapePiece.MovementPattern, int[][]> directionMapHex;
    public DirectionFinder(CoordinateType coordinateType, EscapePiece.MovementPattern movementPattern) {
        this.directionMapSquare = new HashMap<>();
        this.directionMapHex = new HashMap<>();
      if (coordinateType.equals(CoordinateType.SQUARE)) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
        directionMapSquare.put(EscapePiece.MovementPattern.OMNI, directions);
        directionMapSquare.put(EscapePiece.MovementPattern.LINEAR, directions);
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        directionMapSquare.put(EscapePiece.MovementPattern.ORTHOGONAL, directions);
        directions = new int[][]{{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        directionMapSquare.put(EscapePiece.MovementPattern.DIAGONAL, directions); }
      else {
           int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {1, -1}};
             directionMapHex.put(EscapePiece.MovementPattern.OMNI, directions);
          }
      }

    public int[][] getDirections(CoordinateType coordinateType, EscapePiece.MovementPattern movementPattern) {
        if (coordinateType.equals(CoordinateType.SQUARE)) {
           return this.directionMapSquare.get(movementPattern);
        }
        else
            return this.directionMapHex.get(movementPattern);
    }


    public int[] getDirectionsLinear(CoordinateType coordinateType, Coordinate to, Coordinate from) {
        if (coordinateType.equals(CoordinateType.SQUARE)) {
            if (to.getRow() > from.getRow() && to.getColumn() > from.getColumn()) {
                return new int[]{1, 1};
            }
            if (to.getRow() < from.getRow() && to.getColumn() < from.getColumn()) {
                return new int[]{-1, -1};
            }
            if (to.getRow() < from.getRow() && to.getColumn() > from.getColumn()) {
                return new int[]{-1, 1};
            }
            if (to.getRow() > from.getRow() && to.getColumn() < from.getColumn()) {
                return new int[]{1, -1};
            }

            if (to.getRow() == from.getRow()) {
                if (from.getColumn() < to.getColumn()) {
                    return new int[]{0, 1};
                } else
                    return new int[]{0, -1};
            } else if (from.getRow() < to.getRow()) {
                return new int[]{1, 0};
            }
            return new int[]{-1, 0};
        }
        else
        {

        }
   return null;
    }

}
