public class DiscreteMaths {

    public double[][] transposedMatrix(double[][] matrix) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        double[][] transposed = new double[columns][lines];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public double[][] reverseMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] matrixIdentity = new double[n][n];
        double[][] reverseMatx = new double[n][n];
        // Initialize the identity matrix
        for (int i = 0; i < n; i++) {
            matrixIdentity[i][i] = 1;
        }
        // Reduction
        for (int k = 0; k < n; k++) {
            double aux = matrix[k][k];
            for (int j = 0; j < n; j++) {
                matrix[k][j] /= aux;
                matrixIdentity[k][j] /= aux;
            }
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = matrix[i][k];
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] -= factor * matrix[k][j];
                        matrixIdentity[i][j] -= factor * matrixIdentity[k][j];
                    }
                }
            }
        }
        //Identity matrix reduced to the inverse matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reverseMatx[i][j] = matrixIdentity[i][j];
            }
        }
        return reverseMatx;
    }

    public double[][] multMatrix(double[][] matrix1, double[][] matrix2) {
        int lineMatrix1 = matrix1.length;
        int columnMatrix1 = matrix1[0].length;
        int lineMatrix2 = matrix2.length;
        int columnMatrix2 = matrix2[0].length;
        if (columnMatrix1 != lineMatrix2) {
            throw new IllegalArgumentException("You cannot multiply the matrix by the vector, dimensions do not match.");
        }
        double[][] result = new double[lineMatrix1][columnMatrix2];
        for (int i = 0; i < lineMatrix1; i++) {
            for (int j = 0; j < columnMatrix2; j++) {
                double sum = 0;
                for (int k = 0; k < columnMatrix1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }


    public double[] multiplyMatrixByVector(double[][] matrix, double[] vector) {
        int line = matrix.length;
        int column = matrix[0].length;
        if (column != vector.length) {
            throw new IllegalArgumentException("You cannot multiply the matrix by the vector, dimensions do not match.");
        }
        double[] result = new double[line];
        for (int i = 0; i < line; i++) {
            double sum = 0;
            for (int j = 0; j < column; j++) {
                sum += matrix[i][j] * vector[j];
            }
            result[i] = sum;
        }
        return result;
    }

    public double[] regression(double[][] x, double[] y) {
        double[][] xT = transposedMatrix(x);
        double[][] xTx = multMatrix(xT, x);
        double[][] xTxInverse = reverseMatrix(xTx);
        double[] xTy = multiplyMatrixByVector(xT, y);
        return multiplyMatrixByVector(xTxInverse, xTy);
    }
}