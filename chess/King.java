package chess;

public class King extends Piece{
    private final static String BLACK_KING = "\u265a";
    private final static String WHITE_KING = "\u2654";
    public King(PieceColour colour)
    {
        this.colour = colour;
        switch (this.colour)
        {
            case BLACK:
                setSymbol(BLACK_KING);
                break;
            case WHITE:
                setSymbol(WHITE_KING);
                break;
        }
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        // absolute difference in x and y movement
        int yMovement = Math.abs(currentY - nextY);
        int xMovement = Math.abs(currentX - nextX);
        Square square = Board.getBoard()[nextX][nextY];

        // final result fo the checking
        boolean movementEval = false;
        switch (xMovement)
        {
            case 0:
                movementEval = yMovement == 1;
                break;
            case 1:
                movementEval = yMovement == 0 || yMovement == 1;
                break;
        }
        return (!square.hasPiece() || square.getPiece().getColour() != this.getColour()) && movementEval;
    }
}
