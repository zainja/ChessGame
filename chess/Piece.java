package chess;
public abstract class Piece {
    protected PieceColour colour;
    private int row,column;
    private String symbol;

    public Piece() {

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public PieceColour getColour() {
        return colour;
    }
    public void updateCoordinates(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /**
     *
     * @param currentX: current x location
     * @param currentY: current y location
     * @param nextX : the desired x location to move to
     * @param nextY : the desired y location to move to
     * @return : returns true/false depending on the piece
     */
    public abstract boolean  isLegitMove(int currentX, int currentY, int nextX, int nextY);

    public String toJSON(){
        return String.format("{ \"PieceColour\": %s,\"row\": %d,\"column\": %d,\"symbol\": %s}",
                this.colour, this.row, this.column, this.symbol);
    }

    public static Piece fromJSON(String json){
        String[] jArray = json.split(",");
        boolean isBlack = false;
        int row = 0;
        int col = 0;
        String symbol = "";

        for (String property:
             jArray) {
            String [] propertyArray = property.split(":");
            propertyArray[0] = propertyArray[0].replaceAll("\\{|\\}","").trim();
            propertyArray[1] = propertyArray[1].replaceAll("\\}","").trim();
            switch (propertyArray[0]){
                case "\"PieceColour\"":
                    if (propertyArray[1].equals("BLACK")){
                        isBlack = true;
                    }
                    break;
                case "\"row\"":
                    row = Integer.parseInt(propertyArray[1]);
                    break;
                case "\"column\"":
                    col = Integer.parseInt(propertyArray[1]);
                    break;
                case "\"symbol\"":
                    symbol = propertyArray[1];
                    break;
            }
        }
        Piece piece = fromSymbol(symbol);
        piece.updateCoordinates(row, col);

        return piece;
    }

    public static Piece fromSymbol(String symbol){
        Piece piece;
        switch (symbol) {
            case "\u265d":
                piece = new Bishop(PieceColour.BLACK);
                break;
            case "\u2657":
                piece = new Bishop(PieceColour.WHITE);
                break;
            case "\u265a":
                piece = new King(PieceColour.BLACK);
                break;
            case "\u2654":
                piece = new King(PieceColour.WHITE);
                break;
            case "\u265E":
                piece = new Knight(PieceColour.BLACK);
                break;
            case "\u2658":
                piece = new Knight(PieceColour.WHITE);
                break;
            case "\u265f":
                piece = new Pawn(PieceColour.BLACK);
                break;
            case "\u2659":
                piece = new Pawn(PieceColour.WHITE);
                break;
            case "\u265B":
                piece = new Queen(PieceColour.BLACK);
                break;
            case "\u2655":
                piece = new Queen(PieceColour.WHITE);
                break;
            case "\u265c":
                piece = new Rook(PieceColour.BLACK);
                break;
            default:
                piece = new Rook(PieceColour.WHITE);
                break;
        }
        return piece;

    }
}
