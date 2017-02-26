/**
 * Created by Wenjian on 2017/2/26, 0026.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Given a long number, output it's prime factors by ascend order
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long longNum = sc.nextLong();

        List<Long> primeFactors = new ArrayList<>();
        if(getPrimeFactors(longNum, primeFactors)) {
        /*print*/
            Collections.sort(primeFactors);
            for (int i = 0; i < primeFactors.size() - 1; i++) {
                System.out.print(primeFactors.get(i) + " ");
            }
            System.out.println(primeFactors.get(primeFactors.size() - 1));
        }
        else System.out.println("Error!");
    }

    /**
     *
     * @param longNum, the number to be divided
     * @param primeFactors, the number's factors
     * @return
     */
    private static boolean getPrimeFactors(long longNum, List<Long> primeFactors) {
        if(longNum < 2) return false;
        long quotient = longNum;
        while(quotient != 1) {
            for(long i = 2; i <= quotient; i++) {
                if(isPrime(i) && (quotient % i == 0)) {
                    primeFactors.add(i);
                    quotient = quotient / i;
                }
            }
        }
        return true;
    }

    /**
     * check whether a number is a prime or not
     * @param num
     * @return
     */
    private static boolean isPrime(long num) {
        if(num <= 1) return false;
        for(long i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
