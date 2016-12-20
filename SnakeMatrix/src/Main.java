/**
 * Created by Wenjian on 2016/12/20, 0020.
 */

import java.util.Scanner;

/**
 * input the a integer number, output a triple matrix
 * For example: input 5
 * Output:
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * use an array matrix[][] to store the matrix
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = getSnakeMatrix(N);
        printSnakeMatrix(matrix, N);
    }

    /**
     *
     * @param N
     * @return, snake matrix
     * matrix[0][0] = 1;
     * matrix[1][0] = 2; matrix[0][1] = 3;
     * matrix[2][0] = 4; matrix[1][1] = 5; matrix[0][2] = 6;
     * ...
     */
    private static int[][] getSnakeMatrix(int N) {
        int[][] matrix = new int[N][N];
        int number = 1;
        for (int i = 0; i < N; i++) { /* The i-th line*/
            int x = i; /*row start from i*/
            int y = 0; /*column start from 0*/
            while (x >= 0) { /*row from i->0, and column from 0->i*/
                matrix[x][y] = number;
                number++;
                x--;
                y++;
            }
        }
        return matrix;
    }

    /**
     *
     * @param matrix, print this matrix
     * @param N, matrix's length
     */
    private static void printSnakeMatrix(int[][] matrix, int N){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - i; j++){
                if(j == (N - i - 1)) System.out.print(matrix[i][j]);
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();/*next row*/
        }
    }
}
