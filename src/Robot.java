public class Robot {
    private int row;
    private int column;

    public Robot(int startRow, int startColumn) {
        row = startRow;
        column = startColumn;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    public void setPosition(int newRow, int newColumn) {
        row = newRow;
        column = newColumn;
    }

}
