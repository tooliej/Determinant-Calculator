
public class Determinant {
    public static void main(String[] args) {

        //Builds a random matrix
        int[][] a = MatrixBuilder.random(3,3,4);


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
        //TODO Checks that the matrix is square

        //Clones the original matrix
        int[][] clone = cloneArray(matrix);

        int det = 0;
        int i = 0; //mostZeros(matrix); // Need to see if mostZeros function actually makes calculation more efficient

        for (int j = 0; j < matrix[0].length; j++) {

            // Runs only once for a 2x2 matrix
            if (!(matrix[0].length == 2 && j == 1)) {

                det += determinant(clone, i, j);
           }
        }

        return det;
    }

    /**
     * Deep copy of the matrix so that manipulations on the matrix for the purpose of the determinant calculation do not
     * change the original matrix
     * @param srcMatrix
     * @return
     */
    private static int[][] cloneArray(int[][] srcMatrix) {
        int length = srcMatrix.length;
        int[][] clone = new int[length][srcMatrix[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(srcMatrix[i], 0, clone[i], 0, srcMatrix[i].length);
        }
        return clone;
    }

    /**
     * Recursively calculates the determinant of a matrix
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private static int determinant(int[][] arr, int i, int j) {
        int sign  = 1;
        int size = arr.length;

        //Determines if the minor is added or subtracted
        if ((i + j) % 2 != 0)
            sign = -sign;

        //Base case
        if (size == 2)
            return (arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0]);

        // Returns 0 if the value of one of the spots in the matrix is zero
        if (arr[i][j] == 0)
            return 0;

        return determinant(minor(arr, i, j)) * sign * arr[i][j];
    }

    /**
     * Returns the minor of a matrix
     * @param arr
     * @param i
     * @param j
     * @return - The minor
     */
    private static int[][] minor(int[][] arr, int i, int j) {


        if(i == 0 && j==0) {
            int[][] minor = new int[arr.length - 1][arr.length - 1];
            for (int k = 0; k < minor.length; k++) {
                for (int l = 0; l < minor[0].length; l++) {
                    minor[k][l] = arr[k + 1][l + 1];
                }
            }
            return minor;
        }

        int[][] minor = new int[arr.length - 1][arr.length];

        //Copies all the rows or arr to minor excluding row i
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < minor[0].length; l++) {
                minor[k][l] = arr[k][l];
            }
        }


        //Moves all the rows from k + 1 back one row
        for (int k = i; k < minor.length; k++) {
            for (int l = 0; l < minor[0].length; l++) {
                minor[k][l] = arr[k + 1][l];
            }
        }
        return removeColumn(minor, j);

    }

    /**
     *
     * @param arr
     * @param j
     * @return
     */
    private static int[][] removeColumn(int[][] arr, int j) {
        int[][] minor = new int[arr.length][arr[0].length - 1];

        //Moves all the columns from j + 1 back one column
        for (int k = 0; k < minor.length; k++) {
            for (int l = 0; l < j; l++) {
                minor[k][l] = arr[k][l];
            }
        }

        for (int k = 0; k < minor.length; k++) {
            for (int l = j; l < minor[0].length; l++) {
                minor[k][l] = arr[k][l + 1];
            }
        }

        return minor;
    }

    /**
     * Determains which row has the most zeros
     * @param arr
     * @return
     */
    private static int mostZeros(int[][] arr) {
        int[] counter = new int [arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0)
                    counter[i]++;
            }
        }

        int max = counter[0];
        int maxIndex = 0;

        for(int i = 1; i < counter.length; i++){
            if (counter[i] > max)
                maxIndex = i;
        }
        return maxIndex;
    }


}
