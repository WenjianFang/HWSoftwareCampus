/**
 * Created by Wenjian on 2016/12/30, 0030.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  several thread, write something to a public array in turns
 *  it is weird
 */
public class Main {
    static StringBuilder gWrite = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        /*loop to call thread, it is weird*/
        ExecutorService es1 = Executors.newCachedThreadPool();
        ExecutorService es2 = Executors.newCachedThreadPool();
        ExecutorService es3 = Executors.newCachedThreadPool();
        ExecutorService es4 = Executors.newCachedThreadPool();
        for(int i = 0; i < num; i++){
            es1.execute(new TaskA());
            es2.execute(new TaskB());
            es3.execute(new TaskC());
            es4.execute(new TaskD());
        }
        System.out.println(gWrite.toString());
    }
    static class TaskA implements Runnable{
        @Override
        public void run() {
            gWrite.append('A');
        }
    }

    static class TaskB implements Runnable{
        @Override
        public void run() {
            gWrite.append('B');
        }
    }

    static class TaskC implements Runnable{
        @Override
        public void run() {
            gWrite.append('C');
        }
    }

    static class TaskD implements Runnable{
        @Override
        public void run() {
            gWrite.append('D');
        }
    }
}
