/**
 * Created by Wenjian on 2017/1/6, 0006.
 */

import java.util.Scanner;

/**
 * Matrix multiply problem
 * Brute Force, just as follow the basic principle
 * A*B=C
 * C[i][j]=SUM_k(A[i][k]*B[k][j]);
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int xA = sc.nextInt();
        int yA = sc.nextInt();
        int xB = yA;
        int yB = sc.nextInt();/*Matrix's length*/
        /*A and B matrix*/
        int[][] A = new int[xA][yA];
        int[][] B = new int[xB][yB];
        /*A matrix input*/
        for(int i = 0; i < xA; i++){
            for(int j = 0; j < yA; j++){
                A[i][j] = sc.nextInt();
            }
        }
        /*B matrix input*/
        for(int i = 0; i < xB; i++){
            for(int j = 0; j < yB; j++){
                B[i][j] = sc.nextInt();
            }
        }
        /*get the multiply of matrix A and B*/
        int[][] C = multiplyOfMatrix(A, xA, yA, B, xB, yB);
        /*print result matrix*/
        for(int i = 0; i < xA; i++){
            for(int j = 0; j < (yB - 1); j++){
                System.out.print(C[i][j] + " ");/*keep last one*/
            }
            System.out.println(C[i][yB - 1]);/*last one*/

        }
    }

    /**
     *
     * @param A, Matrix A
     * @param xA, row length of Matrix A
     * @param yA, column length of Matrix A
     * @param B, Matrix B
     * @param xB, row length of Matrix B, it is equals yA
     * @param yB, column length of Matrix B
     * @return, matrix A multiply B
     */
    private static int[][] multiplyOfMatrix(int[][] A, int xA, int yA, int[][] B, int xB, int yB){
        if(xA <= 0 || yA <= 0 || xB <= 0 || yB <= 0) return null;
        int[][] C = new int[xA][yB];/*(xA * yA) * (xB * yB) = (xA * yB), yA == xB*/
        for (int i = 0; i < xA; i++) {
            for (int j = 0; j < yB; j++) {
                C[i][j] = 0;/*initialization*/
                for (int k = 0; k < yA; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        return C;
    }
}
