/**
 * Created by Wenjian on 2017/2/28, 0028.
 */

import java.util.Scanner;

/**
 * an integer number transfer to binary
 * how many 1 did this binary number have?
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int integerNum = sc.nextInt();

        int count = getNumberOfOne(integerNum);
        System.out.println(count);
    }

    /**
     *
     * @param integerNum
     * @return
     */
    private static int getNumberOfOne(int integerNum) {
        int count = 0;
        int n = integerNum;
        while(n != 0) {
            n = n & (n - 1);
            count ++;
        }
        return count;
    }
}
