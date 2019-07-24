import java.lang.Math;
public class MatrixBuilder {

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

        public static int[][] squareRandom(int N, int range) {
            return random(N, N, range);
        }
}
