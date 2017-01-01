/**
 * Created by Wenjian on 2017/1/1, 0001.
 */

import java.util.Scanner;

/**
 * Give a string
 * get the first not repeating char, if not exist, return '.'
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();/*get input*/

        char firstNoRepeatChar = getFirstNoRepeatChar(str);
        System.out.println(firstNoRepeatChar);
    }

    /**
     * statistics the times every characters
     * and re-traverse the string to find that one
     * @param str
     * @return
     */
    private static char getFirstNoRepeatChar(String str){
        /*as required, if NO result, return '.'*/
        if(str.length() == 0) return '.';
        /*array to statistic the appear times of characters*/
        int[] times = new int[256];/*char number no over 256*/
        for(int i = 0; i < times.length; i++) times[i] = 0;/*initialization*/
        for(int i = 0; i < str.length(); i++){
            times[str.charAt(i)] += 1; /*this character times plus 1*/
        }
        /*re-traverse string to find that char*/
        for(int i = 0; i < str.length(); i++){
            if(times[str.charAt(i)] == 1) return str.charAt(i); /*this one*/
        }

        return '.'; /*no exist*/
    }
}
