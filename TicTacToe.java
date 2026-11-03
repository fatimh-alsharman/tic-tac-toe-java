import java.util.Scanner;

public class TicTacToe {
    static char[] board = {'1','2','3','4','5','6','7','8','9'};

    static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean hasWon(char p) {
        int[][] lines = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };
        for (int[] l : lines) {
            if (board[l[0]] == p && board[l[1]] == p && board[l[2]] == p) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char player = 'X';
        int moves = 0;

        while (true) {
            printBoard();
            System.out.print("Player " + player + ", choose a cell (1-9): ");
            if (!in.hasNextInt()) {
                in.next();
                System.out.println("Enter a number.");
                continue;
            }
            int cell = in.nextInt();
            if (cell < 1 || cell > 9 || board[cell-1] == 'X' || board[cell-1] == 'O') {
                System.out.println("Invalid move, try again.");
                continue;
            }
            board[cell-1] = player;
            moves++;
            if (hasWon(player)) {
                printBoard();
                System.out.println("Player " + player + " wins!");
                break;
            }
            if (moves == 9) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            player = (player == 'X') ? 'O' : 'X';
        }
        in.close();
    }
}
