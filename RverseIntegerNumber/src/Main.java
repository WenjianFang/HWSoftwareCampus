/**
 * Created by Wenjian on 2017/2/28, 0028.
 */

import java.util.Scanner;

/**
 * Given an integer number, output its reverse format
 * 1516000->0006151
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int originalNum = sc.nextInt();

        String reversedNum = reverseIntegerNum(originalNum);
        System.out.println(reversedNum);
    }

    /**
     *
     * @param originalNum
     * @return
     */
    private static String reverseIntegerNum(int originalNum) {
        StringBuilder originalString = new StringBuilder(String.valueOf(originalNum));
        return originalString.reverse().toString();
    }

}
