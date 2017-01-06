/**
 * Created by Wenjian on 2017/1/6, 0006.
 */
import java.util.Scanner;

/**
 * Hundred Wen(Chinese Money in long time ago) buy hundred chicken
 * Male chicken, 5 wen; Female chicken, 3 wen; Child chicken, 1/3 wen
 * => x + y + z = 100...(1)
 * and 5x + 3y + z/3 = 100...(2)
 * Solve the equations and give the several solutions
 * 3*(2)-(1)=> 7x + 4y = 200 => y = 25 - (7/4)x
 * Because y is integer, so x must be 4's times, assume that x = 4k
 * => y = 25 - 7k;
 * => z = 75 + 3k;
 * 0 <= x,y,z <= 100
 * => 0 <= k <= 3
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nothing = sc.nextInt();/*As required, should input an integer, this is redundant*/

        int x = 0;
        int y = 0;
        int z = 0;/*three kinds of chicken's number*/
        for(int k = 0; k <= 3; k++){
            /**follow the analysis of the head part
             * x + y + z = 100;
             * 5x + 3y + z/3 = 100;
             */
            x = 4 * k;
            y = 25 - 7 * k;
            z = 75 + 3 * k;
            /*one solution*/
            System.out.println(x + " " + y + " " + z);
        }
    }
}
