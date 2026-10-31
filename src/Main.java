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

            if (grid[robotRow][robotCol] == 'G') {
                printGrid(grid, robotRow, robotCol);
                System.out.println("Goal!");
                break;
            }

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
        int newRow = row;
        int newCol = column;
        switch (command) {
            case "W":
                newRow--;
                break;

            case "A":
                newCol--;
                break;

            case "S":
                newRow++;
                break;

            case "D":
                newCol++;
                break;

            default:
                System.out.println("Invalid command.");
                return new int[]{row, column};
        }
        if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[newRow].length) {
            if (grid[newRow][newCol] != '#') {
                return new int[]{newRow, newCol};
            }
        }
        return new int[]{row, column};
    }


}