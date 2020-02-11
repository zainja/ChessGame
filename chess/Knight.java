package chess;

import org.junit.experimental.max.MaxHistory;

public class Knight extends Piece{
    private final static String BLACK_KNIGHT = "\u265E";
    private final static String WHITE_KNIGHT = "\u2658";

    public Knight(PieceColour colour) {
        this.colour = colour;
        switch (this.colour)
        {
            case BLACK:
                setSymbol(BLACK_KNIGHT);
                break;
            case WHITE:
                setSymbol(WHITE_KNIGHT);
                break;
        }
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY) {

        int xDistance = Math.abs(currentX - nextX);
        int yDistance = Math.abs(currentY - nextY);
        return (xDistance == 1 && yDistance == 2) ^ (xDistance == 2 && yDistance == 1) &&
                (!this.checkSquare(nextX, nextY) || this.checkSquareColour(nextX, nextY));
    }
}