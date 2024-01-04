

public class AlgoMatrix {
    public int[][] createMatrix() {
        int[][] matrix = new int[3][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
        matrix[0][0] = 1;
        matrix[0][3] = 1;
        matrix[1][1] = 1;
        matrix[1][3] = 1;
        matrix[2][2] = 1;
        matrix[2][3] = 1;

        return matrix;
    }
}
