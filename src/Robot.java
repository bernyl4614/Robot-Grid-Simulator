public class Robot {
    private int row;
    private int column;
    private int steps;

    public Robot(int startRow, int startColumn) {
        row = startRow;
        column = startColumn;
        steps = 0;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    public void move(String command, Grid grid) {
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
                return;
        }
        if (grid.isWalkable(newRow, newCol)) {
            row = newRow;
            column = newCol;
            steps++;
        }
    }

    public int getSteps() {
        return steps;
    }


}
