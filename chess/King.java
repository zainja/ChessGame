package chess;

public class King extends Piece{
    public King(PieceColour colour)
    {
        this.colour = colour;
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        return Math.abs(currentX - nextX) == 1 && Math.abs(currentY - nextY) == 1;
    }
}
