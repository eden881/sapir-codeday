
/**
 * Eden Yemini
 * Gilad Yehuda
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * GolBoard
 */
public class GolBoard {

    private boolean[][] board;

    public GolBoard(int x, int y) {

        board = new boolean[x][y];
    }

    public GolBoard(String filename) {

        Scanner input = getFilScanner(filename);
        String[] dims = input.nextLine().split(" ");
        board = new boolean[Integer.parseInt(dims[0])][Integer.parseInt(dims[1])];

        for (int i = 0; i < board.length; i++) {

            String line = input.nextLine();

            for (int j = 0; j < board[i].length; j++) {

                char c = line.charAt(j);
                board[i][j] = c == '*' ? true : false;
            }
        }
    }

    private Scanner getFilScanner(String filename) {

        try {
            return new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {

            System.out.println("File not found!");
        }

        return null;
    }

    public void set(int x, int y, boolean status) {

        board[x][y] = status;
    }

    public void printBoard() {

        for (boolean[] row : board) {

            for (boolean cell : row)
                System.out.printf(" %s", cell ? "*" : " ");

            System.out.println();
        }

        System.out.println();
    }

    public int countNeighbors(int x, int y) {

        int counter = 0;

        for (int i = x - 1; i <= x + 1; i++) {

            for (int j = y - 1; j <= y + 1; j++) {

                if (i != x || j != y) {

                    try {
                        if (board[i][j]) {
                            counter++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
            }
        }

        return counter;
    }

    public void play(int turns) {

        ArrayList<Coords> toExec = new ArrayList<>();

        for (int k = 0; k < turns; k++) {

            for (int i = 0; i < board.length; i++) {

                for (int j = 0; j < board[i].length; j++) {

                    if (board[i][j] && (countNeighbors(i, j) < 2 || countNeighbors(i, j) > 3))
                        toExec.add(new Coords(i, j, false));

                    else if (!board[i][j] && countNeighbors(i, j) == 3)
                        toExec.add(new Coords(i, j, true));

                }
            }

            for (Coords task : toExec)
                board[task.getX()][task.getY()] = task.getStatus();

            toExec.clear();
        }
    }
}
