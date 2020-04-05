package chess;

import java.util.HashMap;

/**
 * Authored by: Zain Alden Jaffal
 * Student-id: 10344889
 * Date: 27/FEB/2020
 *
 * Board
 */
public class Board {
	static HashMap<Integer,Square> squareHashMap = new HashMap<>();
	private static Square [][] board = new Square[8][8];
	public Board(){
		int counter = 0;
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++){
				board[i][j]=new Square(i,j);
				squareHashMap.put(counter,board[i][j]);
				counter ++;
			}
		}
	}
	public Board(Square[][] board){
		Board.board = board;
	}

	public static Square[][] getBoard(){
		return board;
	}
	
	public void initialisePieces()
	{
		setPiece(0,0,new Rook(PieceColour.BLACK));
		setPiece(0,1,new Knight(PieceColour.BLACK));
		setPiece(0,2,new Bishop(PieceColour.BLACK));
		setPiece(0,3,new Queen(PieceColour.BLACK));
		setPiece(0,4,new King(PieceColour.BLACK));
		setPiece(0,5,new Bishop(PieceColour.BLACK));
		setPiece(0,6,new Knight(PieceColour.BLACK));
		setPiece(0,7,new Rook(PieceColour.BLACK));
		setPiece(1,0,new Pawn(PieceColour.BLACK));
		setPiece(1,1,new Pawn(PieceColour.BLACK));
		setPiece(1,2,new Pawn(PieceColour.BLACK));
		setPiece(1,3,new Pawn(PieceColour.BLACK));
		setPiece(1,4,new Pawn(PieceColour.BLACK));
		setPiece(1,5,new Pawn(PieceColour.BLACK));
		setPiece(1,6,new Pawn(PieceColour.BLACK));
		setPiece(1,7,new Pawn(PieceColour.BLACK));

		//White pieces
		setPiece(6,0,new Pawn(PieceColour.WHITE));
		setPiece(6,1,new Pawn(PieceColour.WHITE));
		setPiece(6,2,new Pawn(PieceColour.WHITE));
		setPiece(6,3,new Pawn(PieceColour.WHITE));
		setPiece(6,4,new Pawn(PieceColour.WHITE));
		setPiece(6,5,new Pawn(PieceColour.WHITE));
		setPiece(6,6,new Pawn(PieceColour.WHITE));
		setPiece(6,7,new Pawn(PieceColour.WHITE));
		setPiece(7,0,new Rook(PieceColour.WHITE));
		setPiece(7,1,new Knight(PieceColour.WHITE));
		setPiece(7,2,new Bishop(PieceColour.WHITE));
		setPiece(7,3,new Queen(PieceColour.WHITE));
		setPiece(7,4,new King(PieceColour.WHITE));
		setPiece(7,5,new Bishop(PieceColour.WHITE));
		setPiece(7,6,new Knight(PieceColour.WHITE));
		setPiece(7,7,new Rook(PieceColour.WHITE));
		
	}
	
	public void printBoard()
	{
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");
		String wsp=" ";String bar="|";
		
		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && board[i][j].hasPiece())
						System.out.print(row + board[i][j].getPiece().getSymbol());
					else if ((j==0) && !board[i][j].hasPiece())
						System.out.print(row + wsp);
					else if (board[i][j].hasPiece())					
						System.out.print(bar + board[i][j].getPiece().getSymbol());
					else					
						System.out.print(bar + wsp);
				}				
				System.out.print(wsp +row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");
	}

	/**
	 * removes the piece on i, j
	 * checks the piece in i1, j1 is a king
	 * sets king down
	 * moves the original piece to the desired location
	 * @param i0 current i
	 * @param j0 current j
	 * @param i1 next i
	 * @param j1 next j
	 * @param p the piece to move
	 * @return if the piece moved killed a king
	 */
	public boolean movePiece(int i0, int j0, int i1, int j1, Piece p) {
		boolean kingDown = false;
		System.out.println("Board.movePiece \n" + p.toJSON());
		board[i0][j0].removePiece();
		if(hasPiece(i1, j1) && getPiece(i1, j1) instanceof King)
		{
			kingDown = true;
		}
		board[i1][j1].removePiece();
		setPiece(i1, j1, p);
		return kingDown;
	}

	public void setPiece(int iIn, int jIn, Piece p){
		board[iIn][jIn].setPiece(p);
	}

	public void setPiece(Piece p){
		board[p.getRow()][p.getColumn()].setPiece(p);
	}
	
	public Piece getPiece(int iIn, int jIn){
		return board[iIn][jIn].getPiece();
	}
	
	public boolean hasPiece(int i, int j)
	{
		return board[i][j].hasPiece();
	}

	public String toJSON(){
		int squareNumber = 0;
		StringBuilder jObject = new StringBuilder("{ \"board\": [ ");
		for (Square [] squareRow:
			 board) {
			for (Square square:
				 squareRow) {
				jObject.append(square.toJSON());
				if (squareNumber < 63){
					jObject.append(",");
				}
				jObject.append("\n");
				squareNumber ++;

			}

		}
		jObject.append("]}");
		return jObject.toString();
	}
	public static Board fromJSON(String json){
		Square [][] squaresArray = new Square[8][8];
		int currentRow = 0;
		int currentColumn = 0;
		String[] boardProperty = json.split("\\[");
		String [] squares = boardProperty[1].split("\\},");
		for (String square: squares) {
			squaresArray[currentRow][currentColumn] = Square.fromJSON(square);
			currentColumn ++;
			if (currentColumn == 8){
				currentColumn = 0;
				currentRow ++;
			}
		}
		return new Board(squaresArray);
	}


}
