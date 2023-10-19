package solutions.matrix;

public class Exercise17 {
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

    public static void main(String[] args) {
        int[][] matrix = {{3, 12, 4, 7, 10}, {6, 8, 15, 11, 4}, {19, 5, 14, 32, 21}, {1, 20, 2, 9, 7}};

        System.out.println(minimumCostPath(matrix));
    }
}
