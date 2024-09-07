import java.util.*;

class Player {
    char playerSymbol;

    Player(char symbol) {
        this.playerSymbol = symbol;
    }
}

class Grid {
    char[][] arr;
    int size;

    Grid(int n) {
        this.size = n;
        this.arr = new char[size][size];
    }

    boolean setTile(int x, int y, char symbol) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            System.out.println("Invalid tile selected, please select a new tile");
            return false;
        }
        if (arr[x][y] != '\0') {
            System.out.println("Tile already set, please select a new tile");
            return false;
        }
        arr[x][y] = symbol;
        System.out.println("Tile " + x + ", " + y + " is set with " + symbol);
        return true;
    }

    void trackState() {
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                System.out.println("-".repeat(size * 4 - 1));
            }
            for (int j = 0; j < size; j++) {
                if (j > 0) {
                    System.out.print("|");
                }
                System.out.print(" " + (arr[i][j] == '\0' ? ' ' : arr[i][j]) + " ");
            }
            System.out.println();
        }
    }

    Boolean checkWinner(char playerSymbol) {
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < size; j++) {
                if (arr[i][j] != playerSymbol) {
                    rowWin = false;
                }
                if (arr[j][i] != playerSymbol) {
                    colWin = false;
                }
            }
            if (rowWin || colWin) return true;
        }

        // Check diagonals
        boolean diagWin1 = true;
        boolean diagWin2 = true;
        for (int i = 0; i < size; i++) {
            if (arr[i][i] != playerSymbol) diagWin1 = false;
            if (arr[i][size - 1 - i] != playerSymbol) diagWin2 = false;
        }
        return diagWin1 || diagWin2;
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the grid (n x n):");
        int n = s.nextInt();
        System.out.println("Creating a grid of: " + n + " x " + n);

        Grid grid = new Grid(n);
        Player p1 = new Player('X');
        Player p2 = new Player('O');

        boolean p1Plays = true;
        boolean win = false;

        for (int i = 0; i < n * n; i++) {
            int row, column;
            boolean isTileSet = false;

            if (p1Plays) {
                System.out.println("Player 1's turn. Enter row and column:");
            } else {
                System.out.println("Player 2's turn. Enter row and column:");
            }

            while (!isTileSet) {
                row = s.nextInt();
                column = s.nextInt();
                isTileSet = grid.setTile(row, column, p1Plays ? p1.playerSymbol : p2.playerSymbol);
            }

            if (grid.checkWinner(p1Plays ? p1.playerSymbol : p2.playerSymbol)) {
                win = true;
                System.out.println(p1Plays ? "Player 1 wins!" : "Player 2 wins!");
                break;
            }

            grid.trackState();
            p1Plays = !p1Plays;
        }

        if (!win) {
            System.out.println("No one wins. Game is a draw.");
        }
        System.out.println("Game ends.");
        s.close();
    }
}
