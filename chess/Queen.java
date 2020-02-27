package chess;
/**
 * Authored by: Zain Alden Jaffal
 * Student-id: 10344889
 * Date: 27/FEB/2020
 *
 * Queen Piece
 */
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

    /**
     * @return like a Bishop or  a Rook
     */
    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        return new Bishop(this.getColour()).isLegitMove(currentX, currentY, nextX, nextY) ||
                new Rook(this.getColour()).isLegitMove(currentX, currentY, nextX, nextY);
    }

}
