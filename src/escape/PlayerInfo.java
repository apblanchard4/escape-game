package escape;

/**
 * Holds info about each player
 */
    public class PlayerInfo {
    private String name;
    private int score;
    private int pieces;

    public PlayerInfo(String name){
        this.name = name;
        this.score=0;
        this.pieces = 0;

    }
    public PlayerInfo(String name, int pieces){
        this.name = name;
        this.score=0;
        this.pieces = pieces;
    }
    public void setScore (int score) {
        this.score += score;
    }
    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
    public String getName () {
        return this.name;
    }
    public int getScore () {
        return this.score;
    }
    public int getPieces () {
        return this.pieces;
    }


    public void removePiece(int value) {
       this.setScore(value);
       this.pieces -= 1;
    }
}
