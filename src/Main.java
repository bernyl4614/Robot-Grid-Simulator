import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Grid area = Grid.loadFromFile("maps/level1.txt");

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