/**
 * Created by Wenjian on 2017/1/2, 0002.
 */

import java.util.Scanner;

/**
 * Every Even number can be plus of two prime numbers
 * Please give the two prime numbers which their difference is minimum
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int evenNumber = sc.nextInt();/*Given even number*/

        /*each number must be the plus of num1 < num and num2 >= num*/
        int minPrime = 0;
        int maxPrime = evenNumber;
        int diff = maxPrime - minPrime; /*initialization*/
        for(int i = 1; i <= evenNumber / 2; i++){
            if(isPrime(i) && isPrime(evenNumber - i) && ((evenNumber - i - i) < diff)){/*two prime and the diff is lower*/
                minPrime = i;
                maxPrime = evenNumber - i;
                diff = maxPrime - minPrime; /*update*/
            }
        }
        System.out.println(minPrime);
        System.out.println(maxPrime);
    }

    /**
     * Check if the number is a prime or not
     * @param num
     * @return, false: NOT a prime; true: A prime
     */
    private static boolean isPrime(int num){
        if(num <= 1) return false; /*less or equal 1 is not prime*/
        for(int i = 2; i <= Math.sqrt(num); i++){ /*start from 2 and end at sqrt(num)*/
            if(num % i == 0) return false; /*have factor except 1 and itself*/
        }
        return true;
    }
}
