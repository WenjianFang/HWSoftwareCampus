/**
 * Created by Wenjian on 2017/1/14, 0014.
 */

import java.util.Scanner;

/**
 * reverse the input string
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*input string*/
        StringBuilder sb = new StringBuilder(sc.nextLine());

        /*reversed string*/
        System.out.println(sb.reverse().toString());
    }
}
