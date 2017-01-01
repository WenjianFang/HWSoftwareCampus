/**
 * Created by Wenjian on 2017/1/1, 0001.
 */

import java.util.Scanner;

/**
 * perfect number: the plus of its factors(except itself) == itself
 * just loop and plus
 * we can see that we just loop until sqrt of number, because it must one<number and another one >number
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); /*range, 1-n*/

        int numberOfPerfectNumber = getNumberOfPerfectNumber(n); /*count the perfect number*/
        System.out.println(numberOfPerfectNumber);
    }

    /**
     *
     * @param n, range
     * @return, the number of perfect number in [1, n]
     */
    private static int getNumberOfPerfectNumber(int n){
        int count = 0;/*count perfect number*/
        if(n <= 1) return count;/*none*/

        for(int i = 2; i < n; i++){
            int factorsSum = 0;
            for(int j = 1; j <= Math.sqrt(i); j++){/*factor start from 1*/
                if(i % j == 0) factorsSum = factorsSum + j + i/j; /* a * b == c, so a and b are both c's factors*/
            }
            if((factorsSum - i) == i) { /*except itself*/
                count ++; /*perfect number*/
            }
        }
        return count;
    }
}
