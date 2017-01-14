/**
 * Created by Wenjian on 2017/1/14, 0014.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * count the number of minus
 * average the positive numbers
 * as required, is the average is integer, just print integer, decimal, keep one decimal
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*the number of nums*/
        int n = sc.nextInt();
        /*n numbers*/
        int[] num = new int[n];
        for(int i = 0; i < n; i++) num[i] = sc.nextInt();
        /*count the minus and average the positve*/
        countMinusAndAveragePositive(num);
    }

    /**
     *
     * @param num, an array
     */
    private static void countMinusAndAveragePositive(int[] num){
        int countMinus = 0;
        int countPositive = 0;
        int sumPositive = 0;

        /*traverse*/
        for(int i = 0; i < num.length; i++){
            if(num[i] < 0) countMinus ++;/*minus number*/
            else{/*positive numbers and count*/
                countPositive ++;
                sumPositive += num[i];
            }
        }
        /*print*/
        System.out.print(countMinus + " ");
        /*average*/
        if(countPositive > 0) {
            if (sumPositive % countPositive == 0) {/*average is integer*/
                System.out.println(sumPositive / countPositive);
            } else {/*not an integer, keep one decimal*/
                System.out.println(new DecimalFormat("#.0").format(sumPositive / (double) (countPositive)));
            }
        }
        else System.out.println(0);
    }
}
