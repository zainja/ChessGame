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
    public abstract boolean  isLegitMove(int currentX, int currentY, int nextX, int nextY);
}
