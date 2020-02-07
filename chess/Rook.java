package chess;

public class Rook extends Piece{
    public Rook(PieceColour colour) {
        this.colour = colour;
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        return (currentX == nextX && nextY != currentY) ^ (currentY == nextY && nextX != currentX);
    }
}
