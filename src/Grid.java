public class Grid {
    private char[][] cells;

    public Grid(char[][] cells) {
        this.cells = cells;
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

}
