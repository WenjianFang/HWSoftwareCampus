/**
 * Created by Wenjian on 2017/2/26, 0026.
 */

import java.util.Scanner;

/**
 * Give a hex number, 0x...
 * transfer to decimal number
 */
public class Main {
    static int HEX = 16;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hexString = sc.next().toString();
        String decString = hexTransToDec(hexString);

        System.out.println(decString);
    }

    /**
     *
     * @param hexString
     * @return
     */
    private static String hexTransToDec(String hexString) {
        int decimalNum = 0;
        /*0xaaa, from i=2->length-1*/
        for(int i = 2; i < hexString.length(); i++) {
            if(getInteger(hexString.charAt(i)) != -1) {
                decimalNum = decimalNum * HEX + getInteger(hexString.charAt(i));
            }
        }
        return String.valueOf(decimalNum);
    }

    /**
     * Transfer a character to a number between 0-16
     * @param ch
     * @return
     */
    private static int getInteger(char ch) {
        if((ch >= '0') && (ch <= '9')) {
            return ch - '0';
        }
        else if((ch >= 'a') && (ch <= 'f')) {
            return (10 + (ch - 'a'));
        }
        else if((ch >= 'A') && (ch <= 'F')) {
            return (10 + (ch - 'A'));
        }
        else
            return -1;
    }
}
