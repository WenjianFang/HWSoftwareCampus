/**
 * Created by Wenjian on 2017/1/12, 0012.
 */

import java.util.Scanner;

/**
 * check the security level of password
 * many principles, It will be showed one by one as follows
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();/*password*/

        int score = getScoreOfPassword(password);
//        System.out.println(score);
        String securityLevel = getSecurityLevel(score);
        System.out.println(securityLevel);
    }

    private static int getScoreOfPassword(String password){
        /**
         * count the number, English character, other characters
         * and follow the principles to calculate the score
         */
        /*English characters including upper and lower case, number characters, symbol characters*/
        int enUpperCharacter = 0;
        int enLowerCharacter = 0;
        int numCharacter = 0;
        int symCharacter = 0;
        for(int i = 0; i < password.length(); i++){
            if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') enUpperCharacter ++;
            else if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') enLowerCharacter ++;
            else if(password.charAt(i) >= '0' && password.charAt(i) <= '9') numCharacter ++;
            else symCharacter ++; /*assume other characters are all symbols*/
        }
        int score = 0;
        /*count scores*/
        /**
         * length:
         * 5: less or equal 4 characters
         * 10: 5-7 characters
         * 25: >= 8 characters
         */
        int length = enUpperCharacter + enLowerCharacter + numCharacter + symCharacter;
        if(length <= 4) score += 5;
        else if(length >= 5 && length <= 7) score += 10;
        else score += 25;

        /**
         * English characters:
         * 0: NO English characters
         * 10: all upper case OR all lower case
         * 20: both upper and lower contains
         */
        if(enUpperCharacter == 0 && enLowerCharacter == 0) score += 0;
        else if(enUpperCharacter == 0 || enLowerCharacter == 0) score += 10;
        else if(enUpperCharacter != 0 && enLowerCharacter != 0) score += 20;

        /**
         * number character
         * 0: NO number characters
         * 10: one number character
         * 20: >= 2 number characters
         */
        if(numCharacter == 0) score += 0;
        else if(numCharacter == 1) score += 10;
        else if(numCharacter >= 2) score += 20;

        /**
         * symbol characters:
         * 0: NO symbol characters
         * 10: one symbol characters
         * 25: >= 2 symbol characters
         */
        if(symCharacter == 0) score += 0;
        else if(symCharacter == 1) score += 10;
        else if(symCharacter >= 2) score += 25;

        /**
         * reward
         * 2: only have number and english characters
         * 3: only have number, english characters and symbol characters
         * 5: upper and lower english characters, number, symbol characters
         */
        if(enUpperCharacter > 0 && enLowerCharacter > 0 && numCharacter > 0 && symCharacter > 0) score += 5;
        else if((enLowerCharacter + enUpperCharacter) > 0 && numCharacter > 0 && symCharacter > 0) score += 3;
        else if((enLowerCharacter + enUpperCharacter) > 0 && numCharacter > 0) score += 2;

        return score;
    }
    /**
     *
     * @param score
     * @return, Given score and return security level string
     */
    private static String getSecurityLevel(int score){
        String security;
        if(score >= 90) security = "VERY_SECURE";
        else if(score >= 80) security = "SECURE";
        else if(score >= 70) security = "VERY_STRONG";
        else if(score >= 60) security = "STRONG";
        else if(score >= 50) security = "AVERAGE";
        else if(score >= 25) security = "WEAK";
        else if(score >= 0) security = "VERY_WEAK";
        else security = "ERROR";
        return security;
    }
}
