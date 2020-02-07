package chess;

public class Knight extends Piece{

    public Knight(PieceColour colour) {
        this.colour = colour;
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY) {
        if (nextX == currentX + 1 && nextY == currentY +2)
        {
            return true;
        }
        else if(nextX == currentX + 2 && nextY == currentY + 1)
        {
            return true;
        }
        else if(nextX == currentX - 1 && nextY == currentY - 2)
        {
            return true;
        }
        else if(nextX == currentX - 2 && nextY == currentY - 1)
        {
            return true;
        }
        else
            {return false;}
    }
}