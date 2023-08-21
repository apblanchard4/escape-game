package escape.board;

import escape.board.coordinates.Location;
import escape.board.coordinates.LocationType;
import escape.required.Coordinate;
import escape.required.EscapeException;
import escape.required.GameStatusImpl;

import java.util.Map;

public class PostMoveUpdater {
    private Map<Coordinate, Location> coordinateLocationMap;
    private Coordinate coordinateFrom;
    private Coordinate coordinateTo;
    private Location from;
    private Location to;
    private int value;
    private GameStatusImpl gameStatus;


    public PostMoveUpdater(Map<Coordinate, Location> coordinateLocationMap, Coordinate from, Coordinate to) {
        this.coordinateLocationMap = coordinateLocationMap;
        this.coordinateFrom = from;
        this.coordinateTo = to;
        this.to = coordinateLocationMap.get(to);
        this.from = coordinateLocationMap.get(from);
        this.value =0;

    }
    public Map<Coordinate, Location> updateCoordinates() {
        EscapePieceImpl pieceFrom = from.getPiece();
        if (checkExit()) {
            this.value = pieceFrom.getValue();
            this.coordinateLocationMap.remove(coordinateFrom);

        }
    else
        movePiece(pieceFrom);
        /* if (to == null) {
            movePiece(pieceFrom);

        } else if (to.getPiece() == null) {
            updateLocationsNoPieceAtTo(pieceFrom);
        }
        else {
            updateLocationsPieceAtFrom(pieceFrom);
        } */
        return this.coordinateLocationMap;
    }

    public GameStatusImpl getGameStatus() {
        return new GameStatusImpl(this.coordinateTo, this.value);
    }
    /**
     *
     * @param escapePiece
     * @return
     */
    public EscapePiece movePiece(EscapePieceImpl escapePiece) {

        Location newLocation = this.coordinateLocationMap.get(coordinateFrom);
        newLocation.setEscapePiece(escapePiece);
        this.coordinateLocationMap.put(coordinateTo, newLocation);
        this.coordinateLocationMap.remove(coordinateFrom);
        return escapePiece;
    }

    /**
     *
     * @param piece
     * @return value associate with the piece if the piece is removed, 0 if not removed
     */
    public void updateLocationsNoPieceAtTo(EscapePieceImpl piece) {
        int pieceValue =0;
        if (to.getLocationType() == LocationType.EXIT) {
            this.value = piece.getValue();
            this.coordinateLocationMap.remove(coordinateFrom);
        }
        else {
        movePiece(piece); }
    }

    public void updateLocationsPieceAtFrom(EscapePieceImpl piece) {
        throw new EscapeException("Handle collisions");
    }

    public boolean checkExit() {
        if (to != null && to.getLocationType() == LocationType.EXIT) {
            return true;
        }
        return false;
    }
}
