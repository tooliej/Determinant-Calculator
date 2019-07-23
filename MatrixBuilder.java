import java.lang.Math;
public class MatrixBuilder {
        public static void main(String args[]) {

            // Creates three matrices, for testing:

            int rows = 3;
            int columns = 3;

            int[][] a = random(rows,columns,10);

            System.out.println("A:");
            print(a);
            System.out.println();

        }

        /**
         *  Prints the given matrix.
         *
         *  @param - the matrix to be printed.
         */
        public static void print(int[][] m) {
            for(int i = 0; i < m.length; i++) {
                for(int j=0; j < m[i].length; j++) {
                    System.out.printf("%4s", m[i][j]);
                }
                System.out.println();
            }
        }



        /**
         * Creates and returns a random matrix
         * The method creates and returns a matrix of N rows and M columns,
         * in which every element is an integer between 0 and range, inclusive.
         *
         * @param N
         * @param M
         * @param range
         * @return A random matrix
         */
        public static int[][] random(int N, int M, int range) {

            int [][] newMatrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++ ) {
                    newMatrix[i][j] = (int) (Math.random() * (range + 1));
                }
            }
            return newMatrix;
        }


        /**
         * Given: a matrix m and two coordinates specified by the integers
         * i1, j1, i2, and j2. The method returns a matrix which is the subset
         * m. The top-left element of the subset is m(i1,j1), and the bottom-right
         * element is m(i2,j2).
         * Assumes that i2>=i1 and j2>=j1.
         *
         * @param i1
         * @param j1
         * @param i2
         * @param j2
         * @return The subset of the given matrix
         */
        public static int[][] subMatrix(int m[][], int i1, int j1, int i2, int j2) {
            int N = i2 - i1;
            int M = j2 - j1;
            int [][] subset = new int[N + 1][M + 1];
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= M; j++ ) {
                    subset[i][j] = m[ i + i1 ][ j + j1 ];
                }
            }
            return subset;
        }
}
