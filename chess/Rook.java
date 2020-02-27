package chess;
/**
 * Authored by: Zain Alden Jaffal
 * Student-id: 10344889
 * Date: 27/FEB/2020
 *
 * Rook class
 */

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
        Square[][] squares = Board.getBoard();
        // moving in the y-axis
        if((currentX == nextX && nextY != currentY))
        {
            // checking the direction of movement
            int yInc = (currentY < nextY) ? 1 : -1;
            int checkY = currentY;

            // check the squares between start and end
            while (checkY != nextY)
            {
                checkY = checkY + yInc;
                // checking for the final destination
                if(checkY == nextY && (!squares[currentX][checkY].hasPiece()
                        || squares[currentX][checkY].getPiece().getColour() != this.getColour()))
                {
                    return true;
                }
                if(squares[currentX][checkY].hasPiece())
                {
                    return false;
                }
            }

            return false;
        }
        // movement in the x-axis
        else if(currentY == nextY && nextX != currentX)
        {
            int xInc = (currentX < nextX) ? 1 : -1;
            int checkX = currentX;
            while (checkX != nextX)
            {
                // direction of movement
                checkX = checkX + xInc;
                // check the final square
                if(checkX == nextX && (!squares[checkX][currentY].hasPiece()
                        || squares[checkX][currentY].getPiece().getColour() != this.getColour()))
                {
                    return true;
                }
                if(squares[checkX][currentY].hasPiece())
                {
                    return false;
                }


            }
        }
        // catch any non-axis movement
        return false;
    }
}
