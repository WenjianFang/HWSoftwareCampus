/**
 * Created by Wenjian on 2017/1/7, 0007.
 */

import java.util.Scanner;

/**
 * Nicomachus Theorem
 * 1^3 = 1
 * 2^3 = 3 + 5
 * 3^3 = 7 + 9 + 11
 * ...
 * integer number's power 3 is several odd numbers plus.
 * Here several is equal to the integer number
 * Given an integer number, output the odd sequence numbers
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();/*input number*/
        String expression = getNicomachusExpression(number);
        System.out.println(expression);
    }

    private static String getNicomachusExpression(int number){
        /**
         * n^3 equals n odd sequence numbers' sum => the average number is (n^3)/n = n^2
         * First: n^2 is odd number, n is also odd, the sequence number is a1, a2, ... an;
         *        the middle number is a((n-1)/2) = n^2, => a1 + 2*((n-1)/2) = n^2 => a1 = n^2-n+1;(arithmetic progression)
         * Second: n^2 is even number, n is also even, the sequence is a1, a2, ... an;
         *        => a1, ..., a(n/2), a(n/2 + 1), ... an;
         *        => a(n/2) = n^2 - 1, a(n/2 + 1) = n^2 + 1;
         *        => a1 + 2*(n/2 - 1) = n^2 - 1 OR a1 + 2*(n/2) = n^2 + 1;(arithmetic progression)
         *        => a1 = n^2 - n + 1;
         */

        if(number <= 0) return null;/*illegal input*/
        StringBuilder expression = new StringBuilder();
        /*start from a1->an, n odd numbers*/
        for(int i = 0; i < number; i++){/*first number plus the diff*/
            if(i == number -1) expression.append((number*number - number + 1 + 2 * i));/*last number not "+"*/
            else expression.append((number*number - number + 1 + 2 * i)).append("+");/*middle numbers have "+" tail*/
        }
        return expression.toString();
    }
}
