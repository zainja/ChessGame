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
	public Piece getPiece()
	{
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

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
}
