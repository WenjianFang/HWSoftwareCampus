/**
 * Created by Wenjian on 2017/1/12, 0012.
 */

import java.util.Scanner;

/**
 * calculate the upper case in the string
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();/*Given string*/

        /**/
        int upperCount = getUpperCount(str);
        System.out.println(upperCount);
    }

    /**
     *
     * @param str, Given string
     * @return, the upper characters's number
     */
    private static int getUpperCount(String str){
        int upperCount = 0;
        if(str.length() > 0){/*the string is NOT null*/
            for(int i = 0; i < str.length(); i++){
                if((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')) upperCount ++; /*upper case*/
            }
        }
        return upperCount;
    }
}
