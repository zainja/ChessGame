package chess;

public class Queen extends Piece{
    public Queen(PieceColour colour) {
        this.colour = colour;
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY) {
        return (currentX == nextX && nextY != currentY) ^ (currentY == nextY && nextX != currentX) ||
                Math.abs((currentY - nextY)/(currentX - nextX)) == 1;
    }
}
