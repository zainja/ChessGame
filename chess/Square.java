package chess;


//This class is partially implemented 
public class Square {
	private int i;
	private int j;
	private boolean hasPiece;
	
	public Square(int iIn, int jIn){
		i=iIn;
		j=jIn;
	}
	
	
	public boolean hasPiece(){
		return hasPiece;
	}
	
}
