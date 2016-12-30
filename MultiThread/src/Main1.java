/**
 * Created by Wenjian on 2016/12/30, 0030.
 */

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  several thread, write something to a public array in turns
 *  it is weird
 */
public class Main1 {
    static StringBuilder gWrite = new StringBuilder();
    static boolean mutex = true;/*a simple lock*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        /*loop to call thread, it is weird*/
        for(int i = 0; i < num; i++){
            acquire();/*acquire critical resource*/
            TaskA(); /*critical section*/
            release(); /*release critical resource*/

            acquire();
            TaskB();
            release();

            acquire();
            TaskC();
            release();

            acquire();
            TaskD();
            release();
        }
        System.out.println(gWrite.toString());
    }

    /**
     * Task A B C and D
     */
    private static void TaskA(){
        gWrite.append('A');
    }
    private static void TaskB(){
        gWrite.append('B');
    }
    private static void TaskC(){
        gWrite.append('C');
    }
    private static void TaskD(){
        gWrite.append('D');
    }

    /**
     * atom operation, this is a spinlocks, not the best solution, but it is a solution
     */
    private static void acquire(){
        while(!mutex); /*if the critical is unavailable, busy waiting*/
        mutex = false; /*I will use this critical, so locks it*/
    }
    private static void release(){
        mutex = true;/*I used it, unlock it */
    }
}
