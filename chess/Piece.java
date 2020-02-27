package chess;
public abstract class Piece {
    protected PieceColour colour;
    private int row,column;
    private String symbol;

    public Piece() {

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public PieceColour getColour() {
        return colour;
    }
    public void updateCoordinates(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    /**
     *
     * @param currentX: current x location
     * @param currentY: current y location
     * @param nextX : the desired x location to move to
     * @param nextY : the desired y location to move to
     * @return : returns true/false depending on the piece
     */
    public abstract boolean  isLegitMove(int currentX, int currentY, int nextX, int nextY);
}
