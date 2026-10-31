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
        Grid area = new Grid(grid);

        Robot robot = new Robot(1, 1);

        while (true) {
            printGrid(grid, robot.getRow(), robot.getColumn());

            System.out.print("Move with WASD: ");
            String command = sc.nextLine().toUpperCase();

            robot.move(command, area);

            if (grid[robot.getRow()][robot.getColumn()] == 'G') {
                printGrid(grid, robot.getRow(), robot.getColumn());
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
}