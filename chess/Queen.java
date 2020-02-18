package chess;

public class Queen extends Piece
{
    private final static String BLACK_QUEEN = "\u265B";
    private final static String WHITE_QUEEN = "\u2655";
    public Queen(PieceColour colour)
    {
        this.colour = colour;
        switch (this.colour)
        {
            case BLACK:
                setSymbol(BLACK_QUEEN);
                break;
            case WHITE:
                setSymbol(WHITE_QUEEN);
                break;
        }

    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        return isLegitAsBishop(currentX, currentY, nextX, nextY) || isLegitAsRock(currentX, currentY, nextX, nextY);
    }

    private boolean isLegitAsBishop(int currentX, int currentY, int nextX, int nextY)
    {
        int xInc = (currentX < nextX) ? 1: -1;
        int yInc = (currentY < nextY) ? 1: -1;
        int checkX = currentX;
        int checkY = currentY;
        if(((currentX != nextX) && Math.abs((currentY - nextY) / (currentX - nextX)) == 1))
        {
            while (checkX != nextX && checkY != nextY)
            {
                checkX = checkX + xInc;
                checkY = checkY + yInc;
                // System.out.printf("Checking coords x = %d y = %d", checkX, checkY);
                if(checkX == nextX && checkY == nextY &&
                        (!Board.getBoard()[checkX][checkY].hasPiece() ||
                                Board.getBoard()[checkX][checkY].getPiece().getColour() != this.getColour()))
                {
                    return true;
                }
                if(Board.getBoard()[checkX][checkY].hasPiece())
                {
                    return false;
                }


            }

        }

        return false;
    }

    private boolean isLegitAsRock(int currentX, int currentY, int nextX, int nextY)
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
