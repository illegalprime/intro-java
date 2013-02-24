public class Smiley {

    public static void main(String[] args) {
        char[][] grid = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                         {' ', '*', '*', ' ', ' ', ' ', ' ', '*', '*', ' '},
                         {' ', '*', '*', ' ', ' ', ' ', ' ', '*', '*', ' '},
                         {' ', ' ', ' ', ' ', '*', '*', ' ', ' ', ' ', ' '},
                         {' ', ' ', ' ', ' ', '*', '*', ' ', ' ', ' ', ' '},
                         {' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' '},
                         {' ', ' ', '*', ' ', ' ', ' ', ' ', '*', ' ', ' '},
                         {' ', ' ', ' ', '*', '*', '*', '*', ' ', ' ', ' '},
                         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};

        // Row-major smiley
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }

        // Column-major smiley.
        // Note that we're assuming each row is same length
        for (int col = 0; col < grid[0].length; ++col) {
            for (int row = 0; row < grid.length; ++row) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
    }
}
