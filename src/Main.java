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
            area.printGrid(robot);

            System.out.print("Move with WASD: ");
            String command = sc.nextLine().toUpperCase();

            robot.move(command, area);

            if (grid[robot.getRow()][robot.getColumn()] == 'G') {
                area.printGrid(robot);
                System.out.println("Goal!");
                break;
            }
        }
    }
}