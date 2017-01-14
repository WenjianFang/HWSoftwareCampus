/**
 * Created by Wenjian on 2017/1/14, 0014.
 */

import java.util.Scanner;

/**
 * Given a string
 * add "*" at the front of number and the end of the number
 * For example:
 *   Jkdi234klowe90a3
 * =>Jkdi*234*klowe*90*a*3*
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*Given string*/
        String string = sc.nextLine();
        String markedString = markNumberInString(string);
        System.out.println(markedString);
    }

    /**
     *
     * @param string, given a string
     * @return, the string that mark the numbers
     */
    private static String markNumberInString(String string){
        /**
         * use a boolean variable to record the last one is a number or not
         * if last one is number, this one is number no mark
         * if last one is number, this one is others, mark
         * if last one is not number, this one is number, mark
         * if last one is not number, this one is not number, no mark
         */
        boolean lastOneIsNumber = false;
        /*new string*/
        StringBuilder newString = new StringBuilder();
        /*start traverse*/
        for(int i = 0; i < string.length(); i++){
            /*if last one is number*/
            if(lastOneIsNumber){
                /*this one is NOT number*/
                if(string.charAt(i) < '0' || string.charAt(i) > '9'){
                    lastOneIsNumber = false;/*update the last one*/
                    /*add "*"*/
                    newString.append("*");
                }
                else{
                    lastOneIsNumber = true;
                }
            }
            /*last one is not number*/
            else {
                /*this one is number*/
                if(string.charAt(i) >= '0' && string.charAt(i) <= '9'){
                    lastOneIsNumber = true;
                    /*add "*" */
                    newString.append("*");
                }
                else{
                    lastOneIsNumber = false;
                }
            }
            newString.append(string.charAt(i));
        }
        /*last one is number, add "*" at the last*/
        if(lastOneIsNumber){
            newString.append("*");
        }
        return newString.toString();
    }
}
