package chess;

import java.io.Console;
import java.util.Scanner;

public class Game {
	private static boolean gameEnd=false;

	public Game(){
		CheckInput checkInput = new CheckInput();
		Board b = new Board();
		b.initialisePieces();
		b.printBoard();
		Scanner scanner = new Scanner(System.in);
		while (!gameEnd){
			String origin = scanner.next("Enter Origin: ");
			while (!checkInput.checkCoordinateValidity(origin))
			{
				origin = scanner.next("Incorrect Enter Origin Again: ");
			}
			String destination = scanner.next("Enter Destination");
			while (!checkInput.checkCoordinateValidity(destination))
			{
				destination = scanner.next("Incorrect Enter Destination Again: ");
			}
		}
	}
	
	
	public static void main (String[] args){
		Game g  = new Game();
	}
}
