/**
 * Created by Wenjian on 2017/1/14, 0014.
 */

import java.util.Scanner;

/**
 * Given two numbers, get the minimum common multiple of them
 * we knew that minCommonMultiple * maxCommonDivisor = theirMultiply
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*two numbers*/
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        /*get greatest common divisor*/
        int maxCommonDivisor = getGreatestCommonDivisor(num1, num2);
//        System.out.println(maxCommonDivisor);
        /*minCommonMultiple = theirMultiply / maxCommonDivisor*/
        long minCommonMultiple = ((long)num1 * num2) / maxCommonDivisor;
        System.out.println(minCommonMultiple);
    }

    /**
     *
     * @param num1
     * @param num2
     * @return, the num1 and num2 's greatest common divisor
     */
    private static int getGreatestCommonDivisor(int num1, int num2){
        /**
         * here use iterative divide method, also called Euclid method
         * that is greatestCommonDivisor(num1, num2) = greatestCommonDivisor(num2, num1%num2);
         * we can use recursive, but consider the stack mighit overflow if the num is too large
         * we use the loop, the stop condition is num1 % num2 == 0, and num2 is the greatest common divisor
         */
        int tmp = num1;
        while(num1 % num2 != 0){
            tmp = num1;/*record num1*/
            /*update*/
            num1 = num2;
            num2 = tmp % num2;
        }
        if(num1 % num2 == 0) return num2;
        else return 1;/*everyone's divisor*/
    }
}
