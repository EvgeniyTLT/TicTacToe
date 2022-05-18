public class GridPainter {

    char[][] grid;

    public GridPainter(char[][] arr) {
        this.grid = arr;
    }

    public void show() {

        System.out.println(grid[0][0] + " " + grid[0][1] + " " + grid[0][2]);
        System.out.println(grid[1][0] + " " + grid[1][1] + " " + grid[1][2]);
        System.out.println(grid[2][0] + " " + grid[2][1] + " " + grid[2][2]);
    }

    public void emptyGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '_';
            }
        }
    }
}
