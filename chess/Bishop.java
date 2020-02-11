package chess;

public class Bishop extends Piece
{
    private final static String BLACK_BISHOP = "\u265d";
    private final static String WHITE_BISHOP = "\u2657";


    Bishop(PieceColour colour)
    {
        this.colour = colour;
        switch (this.colour)
        {
            case BLACK:
                setSymbol(BLACK_BISHOP);
                break;
            case WHITE:
                setSymbol(WHITE_BISHOP);
                break;
        }
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        Square square = new Square(nextX, nextY);
        if (square.hasPiece())
        {
            if(square.getPiece().colour == this.colour)
            {
                return false;
            }

        }

        return (currentX != nextX) && Math.abs((currentY - nextY) / (currentX - nextX)) == 1;
    }
}
