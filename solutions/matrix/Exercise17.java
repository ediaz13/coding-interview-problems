package solutions.matrix;

public class Exercise17 {

    /*
    Given a matrix of size n*m that contains only 0s and 1s, where 0 means that the cell is empty and 1 means that there is a wall in that cell, create a function that returns the number of paths that we can take to go from the top left cell to the right bottom cell, knowing that you can move to the right or to the bottom only.

    Example 1:

    Input: matrix = [[0, 0, 0, 0, 1], [1, 0, 1, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]

    Output: 4

    Explanation:
     */
    public static int minimumCostPath(int[][] matrix){
        // your code here
        int rows = matrix.length;
        int columns = matrix[0].length;

        int [][] cost = new int[rows][columns];
        cost[0][0] = matrix[0][0];

        for (int i = 1; i < columns; i++) {
            cost[0][i] = cost[0][i-1] + matrix[0][i];
        }
        for (int i = 1; i < rows; i++ ) {
            cost[i][0] = cost[i-1][0] + matrix[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                cost[i][j] = Math.min(cost[i -1][j], cost[i][j - 1]) + matrix[i][j];
            }
        }

        return cost[rows - 1][columns - 1];
    }

    public static int minimumCostPath(int[][] matrix,int i ,int j){
        int rows = matrix.length;
        int col = matrix[0].length;

        if (i == rows - 1 && j == col -1) {
            return matrix[i][j];
        } else if (i == rows - 1) {
            return matrix[i][j] + minimumCostPath(matrix, i, j +1);
        } else if (j == rows - 1) {
            return matrix[i][j] + minimumCostPath(matrix, i + 1, j);
        } else {
            return matrix[i][j] + Math.min(minimumCostPath(matrix, i + 1, j), minimumCostPath(matrix, i, j + 1));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 12, 4, 7, 10}, {6, 8, 15, 11, 4}, {19, 5, 14, 32, 21}, {1, 20, 2, 9, 7}};

        System.out.println(minimumCostPath(matrix));
        System.out.println(minimumCostPath(matrix, 1, 1));

    }
}
