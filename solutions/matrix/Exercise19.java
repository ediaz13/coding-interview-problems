package solutions.matrix;

public class Exercise19 {

    /*
    Given a matrix of size n*m that contains only 0s and 1s, where 0 means that the cell is empty and 1 means that there is a wall in that cell, create a function that returns the number of paths that we can take to go from the top left cell to the right bottom cell, knowing that you can move to the right or to the bottom only.

    Example 1:

    Input: matrix = [[0, 0, 0, 0, 1], [1, 0, 1, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]

    Output: 4

    Explanation:
     */

    public static int paths(int[][] matrix){
        // your code here
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dynamicProgrammingArr = new int[row][col];


        if (matrix[0][0] == 1) {
            dynamicProgrammingArr[0][0] = 0;
        } else {
            dynamicProgrammingArr[0][0] = 1;
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 1) {
                dynamicProgrammingArr[i][0] = 0;
            } else {
                dynamicProgrammingArr[i][0] = dynamicProgrammingArr[i-1][0];
            }
        }

        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 1) {
                dynamicProgrammingArr[0][j] = 0;
            } else {
                dynamicProgrammingArr[0][j] = dynamicProgrammingArr[0][j - 1];
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dynamicProgrammingArr[i][j] = 0;
                } else {
                    dynamicProgrammingArr[i][j] = dynamicProgrammingArr[i-1][j] + dynamicProgrammingArr[i][j-1];
                }
            }
        }
        return dynamicProgrammingArr[row - 1][col - 1];
    }

    public static int paths(int[][] matrix, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (i > row - 1 || j > col - 1 || matrix[i][j] == 1) {
            return 0;
        } else if (i == row -1 || j == col - 1) {
            return 1;
        } else {
            return paths(matrix, row+1, col) + paths(matrix, row, col + 1);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 0, 1}, {1, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(Exercise19.paths(matrix));

    }
}
