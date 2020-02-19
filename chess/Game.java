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
        int x = 0, y = 0, x2 = 0, y2 = 0;
        PieceColour playerColour;
        String origin;
        String currentPlayer;
        boolean playerOne = true;
        while (!gameEnd){
            if(playerOne)
            {
                currentPlayer = "White";

            }else {
                currentPlayer = "Black 2";
            }
            System.out.printf("------ %s ------\n", currentPlayer);
            boolean correctInput = false;
            while (!correctInput) {
                System.out.printf("%s Enter origin: \n", currentPlayer);
                origin = scanner.next();
                while (!checkInput.checkCoordinateValidity(origin))
                {
                    System.out.println("Enter origin again: ");
                    origin = scanner.next();
                }
                x = iConverter(origin.charAt(0));
                y = jConverter(origin.charAt(1));

                playerColour = (playerOne) ? PieceColour.WHITE : PieceColour.BLACK;
                while (!b.hasPiece(x, y) || b.getPiece(x, y).getColour() != playerColour)
                {
                    System.out.println("Enter origin again");
                    origin = scanner.next();
                    if (checkInput.checkCoordinateValidity(origin))
                    {
                        x = iConverter(origin.charAt(0));
                        y = jConverter(origin.charAt(1));
                    }
                }

                System.out.printf("Selected piece %s \n", b.getPiece(x, y).getSymbol());
                System.out.printf("%s Enter destination: \n", currentPlayer);
                String destination = scanner.next();
                while (!checkInput.checkCoordinateValidity(destination)) {
                    System.out.printf("%s Enter destination again: \n", currentPlayer);
                    destination = scanner.next();
                }
                x2 = iConverter(destination.charAt(0));
                y2 = jConverter(destination.charAt(1));
                correctInput = b.getPiece(x, y).isLegitMove(x, y, x2, y2);
            }
            playerOne = !playerOne;
            System.out.flush();
            gameEnd = b.movePiece(x, y, x2, y2, b.getPiece(x,y));
            b.printBoard();
        }
        if(playerOne)
        {
            System.out.println("Game ended Player 1 Won");

        }else
            {
                System.out.println("Game ended Player 2 Won");
            }
    }


    private static int iConverter(char a)
    {
        return (int) a - CONVERT_X_VALUE;
    }

    private static int jConverter(char a)
    {
        return (int) a - CONVERT_Y_VALUE;
    }
    public static void main (String[] args){
        Game g  = new Game();
    }
}
