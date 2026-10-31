import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grid {
    private char[][] cells;

    public Grid(char[][] cells) {
        this.cells = cells;
    }

    public static Grid loadFromFile(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));

        ArrayList<char[]> rows = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            rows.add(line.toCharArray());
        }
        if (rows.isEmpty()) {
            throw new IllegalArgumentException("Map cannot be empty.");
        }
        int expectedLength = rows.get(0).length;
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).length != expectedLength) {
                throw new IllegalArgumentException("Rows unequal.");
            }
        }
        fileScanner.close();
        char[][] cells = rows.toArray(new char[0][]);
        return new Grid(cells);
    }

    public boolean isWithinBounds(int row, int col) {
        if (row >= 0 && row < cells.length && col >= 0 && col < cells[row].length) {
            return true;
        }
        return false;
    }

    public boolean isWalkable(int row, int col) {
        return isWithinBounds(row, col) && cells[row][col] != '#';
    }

    public void printGrid(Robot robot) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (i == robot.getRow() && j == robot.getColumn()) {
                    System.out.print('R');
                } else {
                    System.out.print(cells[i][j]);
                }
            }
            System.out.println();
        }
    }

    public boolean isGoal(int row, int col) {
        if (isWithinBounds(row, col) && cells[row][col] == 'G') {
            return true;
        }
        return false;
    }
}
