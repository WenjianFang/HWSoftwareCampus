/**
 * Created by Wenjian on 2017/1/11, 0011.
 */

import java.util.Scanner;

/**
 * Given short string and long string
 * Check whether characters in short string are all contains in long string
 * DO NOT care about the order, just contain is ok
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*two string*/
        String shortString = sc.next();
        String longString = sc.next();

        /*match result*/
        boolean match = checkWhetherContain(shortString, longString);
        System.out.println(match);
    }

    /**
     *
     * @param shortString, short string
     * @param longString, long string
     * @return, boolean, whether characters in short string are all in long string, regardless of order
     */
    private static boolean checkWhetherContain(String shortString, String longString){
        /**
         * Brute Force, just check
         */
        /*short is longer than long, it is wrong*/
//        if(shortString.length() > longString.length()) return false;
        for(int i = 0; i < shortString.length(); i++) {/*for every character in short string*/
            boolean match = false;
            /*compare each character in long string*/
            for(int j = 0; j < longString.length(); j++){
                if(shortString.charAt(i) == longString.charAt(j)){
                    match = true;/*match*/
                    break;/*next character*/
                }
            }
            if(!match) return false;
        }
        return true;
    }
}
