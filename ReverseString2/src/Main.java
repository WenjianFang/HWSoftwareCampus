/**
 * Created by Wenjian on 2017/2/28, 0028.
 */

import java.util.Scanner;

/**
 * Given a string, reverse it
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        String reversedString = reverseString(inputString);
        System.out.println(reversedString);
//        System.out.println(new StringBuilder(inputString).reverse().toString());
    }

    /**
     *
     * @param inputString
     * @return
     */
    private static String reverseString(String inputString) {
        StringBuilder reversedString = new StringBuilder(inputString);

        int frontIndex = 0;
        int rearIndex = reversedString.length() - 1;
        char tmpCh;
        while(frontIndex < rearIndex) {
            tmpCh = reversedString.charAt(frontIndex);
            reversedString.setCharAt(frontIndex, reversedString.charAt(rearIndex));
            reversedString.setCharAt(rearIndex, tmpCh);
            frontIndex ++;
            rearIndex --;
        }
        return reversedString.toString();
    }
}
