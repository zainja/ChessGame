import java.io.Console;
import java.util.Scanner;

public class Game {
	private static boolean gameEnd=false;
	private static final int CONVERT_X_VALUE = 49;
	private static final int CONVERT_Y_VALUE = 97;

	public Game(){
		CheckInput checkInput = new CheckInput();
		Board b = new Board();
		b.initialisePieces();
		b.printBoard();
		Scanner scanner = new Scanner(System.in);
		boolean playerOne = true;
		while (!gameEnd){
			int x = 0, y = 0, x2 = 0, y2 = 0;
			PieceColour playerColour;
			String origin = scanner.next();
			x = iConverter(origin.charAt(0));
			y = jConverter(origin.charAt(1));
			playerColour = (playerOne) ? PieceColour.BLACK : PieceColour.WHITE;
			while (!checkInput.checkCoordinateValidity(origin) ||
					(b.hasPiece(x, y) && b.getPiece(x, y).getColour() != playerColour))
			{

				origin = scanner.next();
				x = iConverter(origin.charAt(0));
				y = jConverter(origin.charAt(1));
			}


			String destination = scanner.next();
			while (!checkInput.checkCoordinateValidity(destination) || !b.getPiece(x,y).isLegitMove(x, y, x2, y2))
			{
				System.out.println("Enter Again Destination");
				destination = scanner.next();
				x2 = iConverter(destination.charAt(0));
				y2 = jConverter(destination.charAt(1));
			}

			playerOne = !playerOne;
			System.out.printf("Origin coords %d %d \n Destination coords %d %d \n", x, y, x2, y2);
			b.movePiece(x, y, x2, y2, b.getPiece(x,y));
		}
	}
	

	public static int iConverter(char a)
	{
		return (int) a - CONVERT_X_VALUE;
	}

	public static int jConverter(char a)
	{
		return (int) a - CONVERT_Y_VALUE;
	}
	public static void main (String[] args){
		Game g  = new Game();
	}
}
