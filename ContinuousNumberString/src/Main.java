/**
 * Created by Wenjian on 2017/1/12, 0012.
 */

import java.util.Scanner;

/**
 * Given a string, get the continuous number string that have max length
 * output the string and it's length
 * if the number string is null, just output 0
 * the requirement is not define is there are many number string that have the same length
 * From the community's reply, here we consider the first string that have max length
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*the input string*/
        String str = sc.nextLine();

        /*number string*/
        String numberString = getMaxNumberString(str);
        /*output, if the string is null, just output 0, others, output the string and its length*/
        if(numberString.length() > 0) System.out.println(numberString + "," + numberString.length());
        else System.out.println(0);
    }

    /**
     *
     * @param str, the given string
     * @return, the first number string that have max length
     */
    private static String getMaxNumberString(String str){
        /**
         * traverse and count the number, if meet 0, reset the length
         */
        int currentLength = 0;/*current length of number, initialized to 0*/
        int maxLength = 0; /*record the max length so far*/
        String maxNumberString = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') currentLength ++;
            else{
                if(currentLength > maxLength){
                    maxLength = currentLength;/*update the max length*/
                    maxNumberString = str.substring(i - maxLength, i);/*record the current max number string*/
                }
                currentLength = 0; /*anyway, reset the current length to 0*/
            }
        }
        if(currentLength > maxLength){/*maybe final is also number*/
            maxLength = currentLength;/*update the max length*/
            maxNumberString = str.substring(str.length() - maxLength);/*record the max length string*/
        }
        return maxNumberString;
    }
}
