/**
 * Created by Wenjian on 2016/12/16, 0016.
 */

import java.util.Scanner;

/**
 * Give a line of String, there are at most 128 words
 * Get the length of last word, white space between 2 works
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine().toString();
            String[] strs = str.split(" ");/*split to an array of strings*/
            System.out.println(strs[strs.length-1].length());/*get the length of last one*/
        }
    }
}