import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Random Random = new Random();
    Scanner Scanner = new Scanner(System.in);
    TicTacToe(){ //constructor

        fillBoard();
    }
    public int status = 0; // 0 = playing, 1 = userwin, -1 = cpuwin -2 = tie
    public char[][] board = new char[3][3]; //x = user o = cpu
    private int[] userLocation = new int[2];//user location stored [x, y]
    private int[] CPULocation = new int[2]; //cpu location stored [x, y]

    private void fillBoard(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                board[i][j] = '-';
            }
        }
    }
    public void GetUserLocation(){
        do { //loop until user selects open position
            userLocation[0] = SafeInput.getRangedInt(Scanner, "Enter the x Cordanate (1-3)", 1, 3) - 1;
            userLocation[1] = SafeInput.getRangedInt(Scanner, "Enter the y Cordanate (1-3)", 1, 3) - 1;
            if(board[userLocation[0]][userLocation[1]] == '-'){ //check to make sure position is open
                return;
            }
        }while(true);
    }
    public void CPUMove(){
        do { //loop until cpu selects open position
            CPULocation[0] = Random.nextInt(3);
            CPULocation[1] = Random.nextInt(3);
            if(board[CPULocation[0]][CPULocation[1]] == '-'){ //check if cpu selects open position
                return;
            }
        }while(true);
    }
    public void populateBoard(boolean CPU){ //if true cpu if false player
        if (CPU){
            board[CPULocation[0]][CPULocation[1]] = 'o'; //update board with move
        }else{
            board[userLocation[0]][userLocation[1]] = 'x'; //update board with move
        }
    }
    public void printBoard(){
        for(int i = 0; i<3; i++){ //iterate through rows
            System.out.println();
            for(int j = 0; j<3; j++){ //iterate and print array points through each row
                System.out.printf(String.valueOf(board[j][i]));
            }
        }
    }
    public void getStatus(){
        for (int i = 0; i<3; i++){ //check row for win iterate through row
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]){ //check each row to see if all values are equal
                if(board[i][0] == 'o'){ //check if value is cpu
                    status = -1;
                    return;
                }else if(board[i][0] == 'x'){ //check if value is user
                    status = 1;
                    return;
                }
            }
        }
        for (int i = 0; i<3; i++){//check col for win iterate through col
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]){ //check each col to see if all values are equal
                if(board[0][i] == 'o'){//check if value is cpu
                    status = -1;
                    return;
                }else if(board[0][i] == 'x'){//check if value is user
                    status = 1;
                    return;
                }
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){ //check for diagonal win
            if(board[0][0] == 'o'){//check if value is cpu
                status = -1;
                return;
            }else if(board[0][0] == 'x'){//check if value is user
                status = 1;
                return;
            }
        }
        if(board[2][0] == board[1][1] && board[1][1] == board[0][2]){ //check opasite diagonal
            if(board[2][0] == 'o'){//check if value is cpu
                status = -1;
                return;
            }else if(board[2][0] == 'x'){//check if value is user
                status = 1;
                return;
            }
        }
        for (int i = 0; i < board.length; i++) { //check if tie
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return;
                }
            }
        }
        status = -2;
    }




}
