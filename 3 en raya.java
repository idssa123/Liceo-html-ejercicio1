import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        int turn = 1;
        boolean won = false;

        printBoard(board);

        while (!won) {
            System.out.println("Turn of player " + turn);
            System.out.print("Enter row (1, 2, or 3): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (1, 2, or 3): ");
            int column = scanner.nextInt();

            if (board[row - 1][column - 1] == '\u0000') {
                board[row - 1][column - 1] = (turn == 1) ? 'X' : 'O';
                turn = 3 - turn;
            } else {
                System.out.println("Invalid move, try again");
            }

            printBoard(board);
            won = checkWin(board);
        }

        System.out.println("Player " + turn + " wins!");
    }

    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkWin(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\u0000' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != '\u0000' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] != '\u0000' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '\u0000' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }
