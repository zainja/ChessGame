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

        return new Bishop(this.getColour()).isLegitMove(currentX, currentY, nextX, nextY) ||
                new Rook(this.getColour()).isLegitMove(currentX, currentY, nextX, nextY);
    }

}
