//This class is partially implemented
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
