package escape.board.coordinates;
import escape.board.EscapePiece.*;
import escape.board.EscapePieceImpl;


/**
 * Class to hold the data of each location on the board
 */
public class Location {
    public int x, y;
    public LocationType locationType;
    public String player;
    public EscapePieceImpl escapePiece;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public LocationType getLocationType() {
        return this.locationType;
    }

    public String getPlayer() {
        return this.player;
    }

    public PieceName getPieceName() {
        return escapePiece.getName();
    }

    public Location(int x, int y, String player, EscapePieceImpl piece) {
        this.x = x;
        this.y = y;
        this.locationType = LocationType.CLEAR;
        this.player = player;

        this.escapePiece = piece;
    }

    public Location(int x, int y, LocationType locationType) {
        this.x = x;
        this.y = y;
        this.locationType = locationType;
    }
    /**
     * Constructor when given location type
     *
     * @param x
     * @param y
     * @param locationType
     * @param player
     */
    public Location(int x, int y, LocationType locationType, String player, EscapePieceImpl piece) {
        this.x = x;
        this.y = y;
        this.locationType = locationType;
        this.player = player;
        this.escapePiece = piece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location that)) return false;
        return getX() == that.getX() && getY() == that.getY() && getLocationType() == that.getLocationType() && getPieceName() == that.getPieceName() && getPlayer() == that.getPlayer();
    }

    /**
     * Gets piece at this location
     *
     * @return piece at location, throws error if no piece
     */
    public EscapePieceImpl getPiece() {
        if (this.escapePiece == null)
            return null;

        return this.escapePiece;

    }

    public void setEscapePiece(EscapePieceImpl escapePiece) {
        this.escapePiece = escapePiece;
    }


    public boolean canMove(EscapePieceImpl piece) {

        if (this.getLocationType() == LocationType.CLEAR) {
            if (this.escapePiece == null) {
                return true; }
            else {
                if (piece.getPlayer().equals(this.escapePiece.getPlayer())) {
                    return false;
                }
                else {
                   return false;
                   //conflict resolution needed

                }
            }
        }
        if (this.getLocationType() == LocationType.BLOCK) {
            if (piece.getAttribute(PieceAttributeID.FLY) != null || piece.getAttribute(PieceAttributeID.UNBLOCK) != null ) {
                return true;
            }

            }

        if (this.getLocationType() == LocationType.EXIT) {
            if (piece.getAttribute(PieceAttributeID.FLY) != null) {
                return true;
            }

        }

        return false;
    }

    public boolean canMoveFinal(EscapePieceImpl piece) {
        if (this.getLocationType() == LocationType.CLEAR) {
            if (this.escapePiece == null) {
                return true; }
            else {
                if (piece.getPlayer().equals(this.escapePiece.getPlayer())) {
                    return false;
                }
                else {
                    return false;
                    //conflict resolution needed
                }
            }
        }
        if (this.getLocationType() == LocationType.EXIT) {
           return true;

        }
        return false;
    }
}
