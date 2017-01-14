/**
 * Created by Wenjian on 2017/1/14, 0014.
 */


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Given a double number, return it's cube root
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*double number*/
        double num = sc.nextDouble();
        /*get cube root*/
        double cubeRoot = getCubeRoot(num);
        System.out.println(new DecimalFormat("0.0").format(cubeRoot));
    }

    private static double getCubeRoot(double num){
        /**
         * From Internet, using Newton-Raphson method to approach the target
         * next = (2 * current / 3) + (num / (3 * current * current))
         * iterative to approach target until abs(next - current) < epcel
         */
        if(num == 0.0) return 0.0;
        double e = 0.000001;
        double current = num;
        /*Newton-Raphson method*/
        double next = (2 * current / 3) + (num / (3 * current * current));
        while((next - current) > e || (next - current) < -e){
            /*update the current and next with Newton-Raphon method*/
            current = next;
            next = (2 * current / 3) + (num / (3 * current * current));
        }
        return next;
    }
}
