import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] grid = {
                "##########".toCharArray(),
                "#........#".toCharArray(),
                "#.###....#".toCharArray(),
                "#...#.#..#".toCharArray(),
                "#.#.....G#".toCharArray(),
                "##########".toCharArray()
        };

        int robotRow = 1;
        int robotCol = 1;

        while (true) {
            printGrid(grid, robotRow, robotCol);
            System.out.print("Move with WASD");
            String command = sc.nextLine().toUpperCase();

            int[] newPosition = movement(command, robotRow, robotCol, grid);

            robotRow = newPosition[0];
            robotCol = newPosition[1];

        }
    }

    public static void printGrid(
            char[][] grid,
            int robotRow,
            int robotCol
    ) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == robotRow && j == robotCol) {
                    System.out.print('R');
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static int[] movement(String command, int row, int column, char[][] grid) {
        switch (command) {
            case "W":
                if (grid[row - 1][column] == '#') {
                    break;
                } else {
                    row--;
                    break;
                }

            case "A":
                if (grid[row][column - 1] == '#') {
                    break;
                } else {
                    column--;
                    break;
                }

            case "S":
                if (grid[row + 1][column] == '#') {
                    break;
                } else {
                    row++;
                    break;
                }

            case "D":
                if (grid[row][column + 1] == '#') {
                    break;
                } else {
                    column++;
                    break;
                }

            default:
                System.out.println("Invalid Command.");
        }
        return new int[]{row, column};
    }


}