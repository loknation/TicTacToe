import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean Continue = true;
        TicTacToe gameObject = new TicTacToe();
        do{ //play again loop
            System.out.println("You are the X's, you go first.");
            while(true) { //game loop
                gameObject.GetUserLocation();
                gameObject.populateBoard(false);
                gameObject.printBoard();
                gameObject.getStatus();
                if(gameObject.status == 1){
                    System.out.println("you won");
                    break;
                }
                if(gameObject.status == -2){
                    System.out.println("you tied");
                    break;
                }
                System.out.println(""); //clear console
                System.out.println("***********");
                gameObject.CPUMove();
                gameObject.populateBoard(true);
                gameObject.printBoard();
                System.out.println("");
                gameObject.getStatus();
                if(gameObject.status == -2){
                    System.out.println("you tied");
                    break;
                }
                if(gameObject.status == -1){
                    System.out.println("you lost");
                    break;
                }
            }
            Continue = SafeInput.getYN(scanner, "Do you want to play again");
            gameObject = new TicTacToe();
        }while(Continue);

    }
}
