package chess;

public class Pawn extends Piece{
    public Pawn(PieceColour colour)
    {
        this.colour = colour;
    }
    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        return currentX == nextX && Math.abs(nextY - currentY) == 1;
    }
}
