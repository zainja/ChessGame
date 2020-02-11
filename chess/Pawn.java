package chess;

public class Pawn extends Piece{
    private final static String BLACK_PAWN = "\u265f";
    private final static String WHITE_PAWN = "\u2659";
    public Pawn(PieceColour colour)
    {
        this.colour = colour;
        switch (this.colour)
        {
            case BLACK:
                setSymbol(BLACK_PAWN);
                break;
            case WHITE:
                setSymbol(WHITE_PAWN);
                break;
        }
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY)
    {
        Square square = new Square(nextX, nextY);
        if (square.hasPiece())
        {
            return false;
        }
        boolean legit = true;
        if (currentX == 0)
        {
            switch (this.colour)
            {
                case BLACK:
                    legit = currentY == nextY &&
                            (nextX == currentX - 1 || nextX == currentX + 2);
                    break;
                case WHITE:
                    legit = currentY == nextY &&
                            (nextX == currentX + 1 || nextX == currentX - 2);
                    break;

            }
        }
        else
            {
                switch (this.colour)
                {
                case BLACK:
                    legit = (currentY == nextY) && (nextX == currentX + 1);
                    break;
                case WHITE:
                    legit = currentY == nextY && nextX == currentX - 1;
                    break;
                }
            }

        return legit;


    }
}
