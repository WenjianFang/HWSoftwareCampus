/**
 * Created by Wenjian on 2017/1/5, 0005.
 */

import java.util.Scanner;

/**
 * Wildcard of string:
 *  *: match >= 0 characters
 *  ?: match one character
 *  Given can wildcard and a string
 *  check whether the string is match or not
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*the requirement means, the lower and upper case are the same, so transfer in advance*/
        String wildcard = sc.next().toLowerCase();
        String str = sc.next().toLowerCase();/*transfer to lower case by the way*/


        System.out.println(checkWetherMatch(wildcard, str));
    }

    private static boolean checkWetherMatch(String wildcard, String str){
        return checkWetherMatchRecu(wildcard, 0, str, 0);
    }

    private static boolean checkWetherMatchRecu(String wildcard, int iWildcard, String str, int iStr){
        /**
         * Recursively solve the problem, several cases, String(i) means string start from i
         * First: wildcard is "*", compare wildcard(iWildcard+1) and str(iStr), "*" represents nothing
         * Second: wildcard is "*", compare wildcard(iWildcard) and str(iStr+1), "*" represents at least one character
         * Third: wildcard is "?", compare wildcard(iWildcard+1) and str(iStr+1), "?" represents on character
         * Four: no wildcard, the corresponding character of wildcard and string should be compared
         */
        /*string is last one , and wildcard is "*" */
        if((iStr == (str.length() - 1))
                && (iWildcard == (wildcard.length() - 1))
                && (wildcard.charAt(iWildcard) == '*'))
            return true;

        /*stop condition: the end of wildcard and string*/
        if((iWildcard == wildcard.length()) && (iStr == str.length())) return true;
        /*one is over*/
        if(iWildcard >= wildcard.length() || iStr >= str.length()) return false;
        /*First and Second cases*/
        if(wildcard.charAt(iWildcard) == '*'){
            return checkWetherMatchRecu(wildcard, iWildcard + 1, str, iStr)
                    || checkWetherMatchRecu(wildcard, iWildcard, str, iStr + 1);
        }
        /*Third case*/
        if(wildcard.charAt(iWildcard) == '?'){
            return checkWetherMatchRecu(wildcard, iWildcard + 1, str, iStr + 1);
        }
        /*Four case*/
        if(wildcard.charAt(iWildcard) == str.charAt(iStr)){
            return checkWetherMatchRecu(wildcard, iWildcard + 1, str, iStr + 1);
        }
        /*not match*/
        return false;
    }
}
