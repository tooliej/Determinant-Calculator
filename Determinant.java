
public class Determinant {
    public static void main(String[] args) {

        //Builds a random matrix
        int[][] a = MatrixBuilder.random(4,4,5);

        MatrixBuilder.print(a);
        System.out.println();

        System.out.println("The determinant is: " + determinant(a));
    }

    /**
     * Calculates the determinant of a matrix choosing the row with the least zeros
     * as the row of choice for the calculation
     * @param matrix
     * @return
     */
    public static int determinant(int[][] matrix) {
        //TODO Check that the matrix is square
        return determinant(matrix, matrix[0].length);
    }

    public static int determinant(int[][] matrix, int size) {
        int det = 0;
        int i = 0; //mostZeros(matrix, size); // Need to see if mostZeros function actually makes calculation more efficient

        for (int j = 0; j < size; j++) {

            // Runs only once for a 2x2 matrix
            if (!(size == 2 && j == 1)) {
                det += size > 2?
                        determinant(cloneArray(matrix, size), i, j, size) : determinant(matrix, i, j, size);
           }
        }

        return det;
    }

    private static int determinant(int[][] arr, int i, int j, int size) {
        int sign  = 1;

        //Determines if the minor is added or subtracted
        if ((i + j) % 2 != 0)
            sign = -sign;

        //Base case
        if (size == 2)
            return (arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0]);

        // Returns 0 if the value of one of the spots in the matrix is zero
        if (arr[i][j] == 0)
            return 0;

        int val = arr[i][j];
        minor(arr, i, j, size);

        return determinant(arr, size - 1) * sign * val;
    }


    private static void minor(int[][] arr, int row, int column, int size) {

        for(int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - 1; j++) {
                if(i < row && j < column) continue;

                if(i < row && j >= column) {
                    arr[i][j] = arr[i][j + 1];
                }
                else if(i >= row && j < column) {
                    arr[i][j] = arr[i + 1][j];
                }
                else {
                    arr[i][j] = arr[i + 1][j + 1];
                }
            }
        }
    }

    /**
     * Deep copy of the matrix so that manipulations on the matrix for the purpose of the determinant
     * calculation do not change the original matrix
     * @param srcMatrix
     * @return
     */
    private static int[][] cloneArray(int[][] srcMatrix, int size) {
        int[][] clone = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(srcMatrix[i], 0, clone[i], 0, size);
        }

        return clone;
    }

    /**
     * Determines which row has the most zeros
     * @param arr
     * @param size
     * @return - The row which has most zeros
     */
    private static int mostZeros(int[][] arr, int size) {
        int max = 0;
        int maxRow = 0;
        int current;

        for(int i = 0; i < size; i++) {
            current = 0;
            for(int j = 0; j < size; j++) {
                if(arr[i][j] == 0)
                    current++;
            }

            if(current > max) {
                max = current;
                maxRow = i;
            }
        }

        return maxRow;
    }

}
