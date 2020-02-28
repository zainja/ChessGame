package chess;

/**
 * Authored by: Zain Alden Jaffal
 * Student-id: 10344889
 * Date: 27/FEB/2020
 *
 * Pawn Piece
 */
public class Pawn extends Piece {
    private final static String BLACK_PAWN = "\u265f";
    private final static String WHITE_PAWN = "\u2659";
    public Pawn(PieceColour colour) {
        this.colour = colour;
        switch (this.colour) {
            case BLACK:
                setSymbol(BLACK_PAWN);
                break;
            case WHITE:
                setSymbol(WHITE_PAWN);
                break;
        }
    }

    @Override
    public boolean isLegitMove(int currentX, int currentY, int nextX, int nextY) {
        Square square = Board.getBoard()[nextX][nextY];

        // check if there is a piece in front of the piece
        if(square.hasPiece() && currentY == nextY)
        {
            return false;
        }

        if(this.colour == PieceColour.WHITE) {
            // first movement
            if(currentX == 6) {
                // to move diagonally you need a piece
                if((Math.abs(currentY - nextY) == 1 && square.hasPiece()) && (square.getPiece().getColour() == colour)) {
                    return nextX == currentX - 1;
                }
                // one or two steps movement
                // no need to check for the piece here
                return (nextX ==  5 || nextX ==  4) && nextY == currentY;
            }
            // side movement general
            else if(Math.abs(currentY - nextY) == 1 && square.hasPiece() &&
                    (square.getPiece().getColour() != this.colour)) {
                return nextX == currentX - 1;
            }
            // check for one step movement
            else {
                    return (nextX == currentX - 1) && nextY == currentY;
                }
        }
        // checking for black pawns
        else {
                // first movement
                if(currentX == 1) {
                    if(Math.abs(currentY - nextY) == 1 && square.hasPiece() &&
                            (square.getPiece().getColour() != this.colour)) {
                        return nextX == currentX + 1;

                    }
                    return (nextX ==  2 || nextX ==  3) && nextY == currentY;
                }
                // side movement general case
                else if(Math.abs(currentY - nextY) == 1 && square.hasPiece()) {
                    return square.getPiece().getColour() != this.colour && nextX == currentX + 1;

                }
                // single step movement
                else {
                    return (nextX == currentX + 1) && nextY == currentY;
                }

            }


    }
}
