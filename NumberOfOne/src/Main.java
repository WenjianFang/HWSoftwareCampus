/**
 * Created by Wenjian on 2017/1/2, 0002.
 */

import java.util.Scanner;

/**
 * an integer, how many 1 of its binary number
 * Notice that (n & (n-1)) can eliminate the last 1
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); /*the integer*/
        int numberOfOne = getNumberOfOne(num);
        System.out.println(numberOfOne);
    }

    /**
     *
     * @param num
     * @return
     */
    private static int getNumberOfOne(int num){
        int count = 0;
        if(num == 0) return count; /*0, not 1*/
        while(num != 0){
            /**
             *  (n & (n - 1)) can eliminate last 1
             *  for example, 1011 & 1010 = 1010
             *  when it is 0, there is no 1 in the number
             */
            num = num & (num - 1);
            count ++;
        }
        return count;
    }
}
