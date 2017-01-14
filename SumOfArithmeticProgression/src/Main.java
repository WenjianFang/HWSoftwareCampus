/**
 * Created by Wenjian on 2017/1/14, 0014.
 */

import java.util.Scanner;

/**
 * arithmetic progression, 2, 5, 8, 11, ....
 * Given an integer number
 * return the front numbers' sum
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*the ap's first number, and the diff*/
        int start = 2;
        int diff = 3;
        /*the ap's first front number*/
        int num = sc.nextInt();

        long sum = getSumOfFrontNumbers(start, diff, num);
        System.out.println(sum);
    }

    /**
     *
     * @param start, the arithmetic progression start
     * @param diff, the diff of arithmetic
     * @param num, how many numbers of this arithmetic progression
     * @return the sum of front nums
     */
    private static long getSumOfFrontNumbers(int start, int diff, int num){
        /**
         * an = a1 + (n-1)*d
         * s = (a1+an)*n/2
         */
        long end = start + (num - 1) * diff;
        return ((start + end) * num) / 2;
    }
}
