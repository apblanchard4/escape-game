package escape.board;
import escape.board.coordinates.CoordinateImpl;
import escape.board.coordinates.Location;
import escape.board.validator.MoveValidatorHex;
import escape.board.validator.MoveValidatorSquare;
import escape.board.validator.PathValidator;
import escape.builder.LocationInitializer;
import escape.required.Coordinate;
import escape.required.Coordinate.CoordinateType;
import escape.required.GameStatusImpl;
import java.util.HashMap;
import java.util.Map;

/**
 * EscapeBoard
 * Holds all information about the board
 */
public class EscapeBoard {
    //type of the coordinates (square or hex)
    final CoordinateType coordinateType;
    //max size
    final int xMax, yMax;
    private Map<Coordinate, Location> coordinates;
    PathValidator pathValidator;
    MoveValidator moveValidator;

    /**
     * Constructor
     *
     * @param type coordinate type
     * @param xMax max row
     * @param yMax max column
     */
    public EscapeBoard(CoordinateType type, int xMax, int yMax, LocationInitializer[] locationInitializers) {

        this.coordinateType = type;
        this.xMax = xMax;
        this.yMax = yMax;
        this.coordinates = new HashMap<>();
        if (locationInitializers != null)
            initializeBoard(locationInitializers);
        this.pathValidator = new PathValidator();
        if (type.equals(CoordinateType.SQUARE)) {
            this.moveValidator = new MoveValidatorSquare();
        }
        else {
        this.moveValidator = new MoveValidatorHex(); }
    }

    public void initializeBoard(LocationInitializer[] locationInitializers) {
        for (LocationInitializer singleLocation : locationInitializers) {
            coordinates.put(new CoordinateImpl(singleLocation.getX(), singleLocation.getY()), singleLocation.createLocation());
        }
    }

    /**
     * Initiates move on the board
     * @param player
     * @param from
     * @param to
     * @return GameStatus
     */
    public GameStatusImpl move(String player, Coordinate from, Coordinate to) {
        if (this.moveValidator.validateMove(this, from, to, player)) {
            //if valid, check if valid path
            if (this.pathValidator.isValidPath(this, from, to)) {
                PostMoveUpdater updater = new PostMoveUpdater(this.coordinates, from, to);
                this.coordinates = updater.updateCoordinates();
                return updater.getGameStatus();

            }
        }
        return new GameStatusImpl();
    }

    /**
     * Gets the location from the coordinate hashmap
     *
     * @param coordinate
     * @return Location that holds info about coordinate
     */
    public Location getLocationAt(Coordinate coordinate) {
        Location location = coordinates.get(coordinate);
        return location;
    }
    public EscapePiece getPieceAt(Coordinate coordinate) {
        Location location = coordinates.get(coordinate);
        if (location == null) {
            return null;
        }
        else
            return location.getPiece();
    }

    public CoordinateType getCoordinateType() {
        return coordinateType;
    }
    public int getXMax() {
        return xMax;
    }
    public int getYMax() {
        return yMax;
    }

    /*
    public boolean anyValidMoves(String player) {

        return this.pathValidator.anyValidMoves(this, player);
    }
*/
    public Map<Coordinate, Location> getCoordinates() {
        return coordinates;
    }
}

