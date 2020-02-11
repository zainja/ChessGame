package chess;

public class King extends Piece{
    private final static String BLACK_KING = "\u265a";
    private final static String WHITE_KING = "\u2654";
    public King(PieceColour colour)
    {
        this.colour = colour;
        switch (this.colour)
        {
            case BLACK:
                setSymbol(BLACK_KING);
                break;
            case WHITE:
                setSymbol(WHITE_KING);
                break;
        }
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        boolean checkColour = this.checkSquareColour(nextX,nextY);
        boolean checkMovement = Math.abs(currentX - nextX) == 1 && Math.abs(currentY - nextY) == 1;
        if (checkMovement)
        {
            if(!this.checkSquare(nextX, nextY) )
            {
                return true;
            }
            else return checkColour;
        }
        return false;

    }
}
