/**
 * Created by Wenjian on 2017/2/14, 0014.
 */

import java.util.Scanner;

/**
 * Given a string and a character
 * count how many times the character appear in the string
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine().toLowerCase();/*the string to be count*/
        char specifyCh = sc.nextLine().toLowerCase().charAt(0);/*count which character*/

        int count = countCharacter(inputString, specifyCh);
        System.out.println(count);
    }

    /**
     *
     * @param inputString
     * @param specifyCh
     * @return
     */
    private static int countCharacter(String inputString, char specifyCh){
        /**
         * traverse the string and count
         */
        int count = 0;
        for(int i = 0; i < inputString.length(); i++){
            if(specifyCh == inputString.charAt(i)) count++;
        }
        return count;
    }
}
