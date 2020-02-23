
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
        if((currentX == nextX && nextY != currentY))
        {
            int yInc = (currentY < nextY) ? 1 : -1;
            int checkY = currentY;

            while (checkY != nextY)
            {
                checkY = checkY + yInc;
                if(checkY == nextY && (!Board.getBoard()[currentX][checkY].hasPiece()
                        || Board.getBoard()[currentX][checkY].getPiece().getColour() != this.getColour()))
                {
                    return true;
                }
                if(Board.getBoard()[currentX][checkY].hasPiece())
                {
                    return false;
                }
            }

            return false;
        }
        else if(currentY == nextY && nextX != currentX)
        {
            int xInc = (currentX < nextX) ? 1 : -1;
            int checkX = currentX;
            while (checkX != nextX)
            {
                checkX = checkX + xInc;
                if(checkX == nextX && (!Board.getBoard()[checkX][currentY].hasPiece()
                        || Board.getBoard()[checkX][currentY].getPiece().getColour() != this.getColour()))
                {
                    return true;
                }
                if(Board.getBoard()[checkX][currentY].hasPiece())
                {
                    return false;
                }


            }
        }
       return false;
    }
}
