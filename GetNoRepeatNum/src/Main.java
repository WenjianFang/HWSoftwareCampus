/**
 * Created by Wenjian on 2017/2/27, 0027.
 */

import java.util.Scanner;

/**
 * Given an int number,
 * output the number that no repeat, from right -> left
 * for instance, 9876673 -> 37689
 * if the output string start with 0, not output 0 except there is only 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int integerNum = sc.nextInt();

        int newInteger = getNewInteger(integerNum);
        System.out.println(newInteger);
    }

    private static int getNewInteger(int integerNum) {
        String integerString = String.valueOf(integerNum);
        StringBuilder newString = new StringBuilder();
        for(int i = integerString.length() - 1; i >= 0; i--) {
            if(-1 == newString.indexOf(String.valueOf(integerString.charAt(i)))) {
                newString.append(integerString.charAt(i));
            }
        }
        return Integer.parseInt(newString.toString());
    }
}
