import java.util.Random;

public class MatrixMultiplication {
    public static void main ( String [] args ){

        Random r = new Random();

        int row1 = 10;   //m
        int col1 = 10;   //r
        int col2 = 10;   //n

        int[][] matrix1 = new int [row1][col1];
        int[][] matrix2 = new int [col1][col2];

        //randomly generate matrices
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix1[i][j] = r.nextInt(10);
            }
        }
        for (int i = 0; i < col1; i++) {
            for (int j = 0; j < col2; j++) {
                matrix2[i][j] = r.nextInt(10);
            }
        }

      /* // If you want to see the two matrices before multiplication
        System.out.println("The matrices ");
        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[0].length; j++){
                System.out.print(matrix1[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix2[i][j] + "   ");
            }
            System.out.println();
        }
            System.out.println();
        */
        long startTime = System.nanoTime();

        int[][] product = multiply(matrix1, matrix2, row1, col1, col2);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        //printProduct(product);

        System.out.println(totalTime);
    }
    public static int [][] multiply (int [][] matrix1, int[][]matrix2, int row1, int col1, int col2){
        int[][] product = new int [row1][col2];
        for(int i = 0; i < row1; i++) {               //m
            for (int j = 0; j < col2; j++) {          //n
                for (int k = 0; k < col1; k++) {      //r
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return product;
    }

    public static void printProduct(int[][] product){
        System.out.println("The product of the two matrices is: ");
        for(int i = 0; i < product.length; i++){
            for(int j = 0; j < product[0].length; j++){
                System.out.print(product[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
