package chess;

public class Rook extends Piece{
    private final static String BLACK_ROOK = "\u265c";
    private final static String WHITE_ROOK = "\u2656";
    public Rook(PieceColour colour) {
        this.colour = colour;
        switch (this.colour)
        {
            case BLACK:
                setSymbol(BLACK_ROOK);
                break;
            case WHITE:
                setSymbol(WHITE_ROOK);
                break;
        }
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        return (currentX == nextX && nextY != currentY) ^ (currentY == nextY && nextX != currentX);
    }
}
