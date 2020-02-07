package chess;

public class Bishop extends Piece
{

    Bishop(PieceColour colour)
    {
        this.colour = colour;
        switch (this.colour)
        {
            case WHITE:
                setSymbol("U+2657");
                break;
            case BLACK:
                setSymbol("U+265D");
                break;
        }
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {

        return (currentX != nextX) && Math.abs((currentY - nextY) / (currentX - nextX)) == 1;
    }
}
