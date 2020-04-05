package chess;

/**
 * Authored by: Zain Alden Jaffal
 * Student-id: 10344889
 * Date: 27/FEB/2020
 *
 * Pawn Piece
 */
public class Square
{
	private int i;
	private int j;
	private boolean hasPiece;
	private Piece piece;

	public Square(int iIn, int jIn){
		i=iIn;
		j=jIn;
	}

	public Piece getPiece() {
		return piece;
	}

	/**
	 * assigns the piece into the square object
	 * @param piece
	 * updates the coordinates in piece
	 * sets the has piece true
	 */
	public void setPiece(Piece piece)
	{
		this.piece = piece;
		this.piece.updateCoordinates(i,j);
		this.hasPiece = true;
	}

	public void removePiece()
	{
		this.piece = null;
		this.hasPiece = false;
	}

	public boolean hasPiece()
	{
		return hasPiece;
	}
	public String toJSON() {
		if (this.hasPiece){
			return String.format("{ \"i\":%d, \"j\": %d, \"piece\": %s}",
					this.i, this.j, this.piece.getSymbol());
		}
		return String.format("{ \"i\":%d, \"j\": %d, \"piece\": %s}",
				this.i, this.j, "null");
	}

	public static Square fromJSON(String json){
		String[] jArray = json.split(",");
		int i = 0;
		int j = 0;
		Piece piece = null;
		boolean hasPiece = true;
		for (String property:
				jArray) {
			String [] propertyArray = property.split(":");
			propertyArray[0] = propertyArray[0].replaceAll("\\{|\\}","").trim();
			propertyArray[1] = propertyArray[1].replaceAll("\\}","").trim();
			switch (propertyArray[0]){
				case "\"i\"":
					i = Integer.parseInt(propertyArray[1]);
					break;
				case "\"j\"":
					j = Integer.parseInt(propertyArray[1]);
					break;
				default:
					if (!propertyArray[1].equals("null"))
						piece = Piece.fromSymbol(propertyArray[1]);
					else
						hasPiece = false;
					break;
			}
		}
		Square square = new Square(i, j);
		if (hasPiece)
			square.setPiece(piece);
		return square;

	}
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;	
	}

	public String toString(){
		return String.format("i: %d, j: %d", this.i, this.j);
	}
}
