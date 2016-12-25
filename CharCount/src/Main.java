/**
 * Created by Wenjian on 2016/12/25, 0025.
 */

import java.util.Scanner;

/**
 * Statistic of English Characters, blank, number and other characters
 * traverse would be done
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine().toString();/*String going to be count*/

        int englishChar = getEnglishCharCount(inputString);
        int blankChar = getBlankCharCount(inputString);
        int numberChar = getNumberCharCount(inputString);
        int otherChar = getOtherCharCount(inputString);

        System.out.println(englishChar);
        System.out.println(blankChar);
        System.out.println(numberChar);
        System.out.println(otherChar);
    }

    /**
     *
     * @param str, input string
     * @return, English Char Count
     */
    private static int getEnglishCharCount(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(((str.charAt(i) >= 'a') && (str.charAt(i) <= 'z'))
                    || ((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')))/*between 'a' and 'z' OR 'A' and 'Z'*/
                count++;
        }
        return count;
    }

    /**
     *
     * @param str, input string
     * @return, count blank
     */
    private static int getBlankCharCount(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                count++;
        }
        return count;
    }

    /**
     *
     * @param str, input string
     * @return, count number char
     */
    private static int getNumberCharCount(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if((str.charAt(i) >= '0') && (str.charAt(i) <= '9'))/*number char, between '0' and '9'*/
                count++;
        }
        return count;
    }

    /**
     *
     * @param str, input string
     * @return, count other char
     */
    private static int getOtherCharCount(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(!(((str.charAt(i) >= 'a') && (str.charAt(i) <= 'z'))
                    || ((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z'))
                    || ((str.charAt(i) >= '0') && (str.charAt(i) <= '9'))
                    || (str.charAt(i) == ' ')))
                count++;
        }
        return count;
    }

}
