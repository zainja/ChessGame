package chess;
import java.io.*;
import java.util.Scanner;
/**
 * Authored by: Zain Alden Jaffal
 * Student-id: 10344889
 * Date: 27/FEB/2020
 *
 * main game logic
 */
public class Game {
    private static boolean gameEnd=false;
    private static final int CONVERT_X_VALUE = 49;
    private static final int CONVERT_Y_VALUE = 97;

    public Game() {
        // check input object
        CheckInput checkInput = new CheckInput();
        Board b;
        try {

            b = loadGame();
        }catch (IOException e) {
            b = new Board();
            b.initialisePieces();
        }
        b.printBoard();
        Board.fromJSON(b.toJSON());
        Scanner scanner = new Scanner(System.in);
        // variables that hold the movement for pieces
        int x = 0, y = 0, x2 = 0, y2 = 0;
        // the current piece colour
        PieceColour playerColour;
        // origin string to select piece
        String origin = "";
        // destination input string
        String destination = "";
        // holds the value WHITE of BLACK
        String currentPlayer = "";
        boolean userEnd = false;
        boolean playerOne = true;
        while (!gameEnd){
            // switch between players
            if(playerOne) {
                currentPlayer = "White";

            }else {
                currentPlayer = "Black";
            }
            System.out.printf("------ %s ------\n", currentPlayer);
            try {

                saveGame(b);
            }catch (IOException e){
                System.out.println("Failed to save game");
            }            playerColour = (playerOne) ? PieceColour.WHITE : PieceColour.BLACK;
            boolean correctInput = false;
            while (!correctInput) {
                System.out.printf("%s Enter origin: \n", currentPlayer);
                origin = scanner.next();
                while (!origin.equals("END") && !checkInput.checkCoordinateValidity(origin)) {
                    System.out.println("Invalid Selection \n Enter origin: ");
                    origin = scanner.next();
                }
                if(origin.equals("END")) {
                    userEnd = true;
                    break;
                }
                x = iConverter(origin.charAt(0));
                y = jConverter(origin.charAt(1));
                if (!b.hasPiece(x, y) || b.getPiece(x, y).getColour() != playerColour) {
                    System.out.println("Invalid Selection");
                    continue;
                }
                System.out.printf("Selected piece %s \n", b.getPiece(x, y).getSymbol());
                System.out.printf("%s Enter destination: \n", currentPlayer);
                destination = scanner.next();
                while (!destination.equals("END") && !checkInput.checkCoordinateValidity(destination)) {
                    System.out.printf("%s Enter destination again: \n", currentPlayer);
                    destination = scanner.next();
                }
                if (destination.equals("END")) {
                    userEnd = true;
                    break;
                }
                x2 = iConverter(destination.charAt(0));
                y2 = jConverter(destination.charAt(1));
                correctInput = b.getPiece(x, y).isLegitMove(x, y, x2, y2);
                if(!correctInput) {
                    System.out.println("Enter details again movement is wrong");
                }
            }
            // switch to other players
            playerOne = !playerOne;
            // for deleting the previous board to show the new board in the same place
            System.out.flush();
            // blocking so gameEnd will not be assigned a new value
            if (userEnd) {
                break;
            }
            gameEnd = b.movePiece(x, y, x2, y2, b.getPiece(x,y));
            b.printBoard();
        }
        if(!userEnd) {
            if(playerOne) {
                System.out.println("Game ended White Won");
            }else {
                System.out.println("Game ended Black Won");
            }
        }else {
                System.out.println("Game End");
            }
    }

    private static int iConverter(char a) {
        return (int) a - CONVERT_X_VALUE;
    }

    private static int jConverter(char a) {
        return (int) a - CONVERT_Y_VALUE;
    }
    public static void saveGame(Board board) throws IOException {
        FileWriter fileWriter = new FileWriter("game-save.json");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(board.toJSON());
        bufferedWriter.close();
        fileWriter.close();
        System.out.println("file saved");
    }

    public static Board loadGame() throws IOException {
        FileReader fileReader = new FileReader("game-save.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder jsonContent = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null){
            jsonContent.append(line);
            line = bufferedReader.readLine();
        }
        System.out.println("file loaded");
        return Board.fromJSON(jsonContent.toString());
    }
    public static void main (String[] args) {
        Game g  = new Game();
    }
}
