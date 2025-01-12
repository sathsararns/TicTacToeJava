import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to play Tic-Tac-Toe? (yes/no)");
        String playGame = scanner.nextLine().trim().toLowerCase();

        if (!playGame.equals("yes")) {
            System.out.println("Maybe next time! Goodbye.");
            scanner.close();
            return;
        }

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        String playerA = "A";
        String playerB = "B";
        char markA = 'X';
        char markB = 'O';
        char currentPlayerMark = markA;
        String currentPlayerName = playerA;
        boolean gameRunning = true;

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard(board);

        while (gameRunning) {
            System.out.println("Player " + currentPlayerName + " (" + currentPlayerMark + "), it's your turn!");
            System.out.print("Enter row (1-3): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            int col = scanner.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = currentPlayerMark;
            printBoard(board);

            if (checkWin(board, currentPlayerMark)) {
                System.out.println("Player " + currentPlayerName + " wins!");
                System.out.println("Congratulations! :)");
                gameRunning = false;
            } else if (isBoardFull(board)) {
                System.out.println("It's a draw!");
                gameRunning = false;
            } else {
                if (currentPlayerMark == markA) {
                    currentPlayerMark = markB;
                    currentPlayerName = playerB;
                } else {
                    currentPlayerMark = markA;
                    currentPlayerName = playerA;
                }
            }
        }

        scanner.close();
    }

    //Board
    public static void printBoard(char[][] board) {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("---|---|---");
            }
        }
    }

    //Check if the current player wins
    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }

    
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
