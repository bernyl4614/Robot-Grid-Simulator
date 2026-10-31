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
            System.out.println("Steps taken: " + robot.getSteps());

            if (area.isGoal(robot.getRow(), robot.getColumn())) {
                area.printGrid(robot);
                System.out.println("Goal!");
                break;
            }
        }
    }
}