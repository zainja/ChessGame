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
}
