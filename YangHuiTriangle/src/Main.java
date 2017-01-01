/**
 * Created by Wenjian on 2017/1/1, 0001.
 */

import java.util.Scanner;

/**
 * Input an integer number n, get the first even number of n-th line in Like YangHui Triangle
 *      1
 *    1 1 1
 *  1 2 3 2 1
 *1 3 6 7 6 3 1
 * every number is the plus of its head three number
 * Actually, it is an Recursive problem
 * value(line, i) = value(line-1, i-1)+value(line-1, i)+value(line-1, i+1)
 * if the line too large, the stack might be overflow
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); /*the n-th line*/
        int firstLocationOfEven = -1; /*-1, no even;*/
        for(int i = 1; i < n; i++){
            if((getValueOfLocation(n, i) % 2) == 0){
                firstLocationOfEven = i; /*i is the even integer's location*/
                break;
            }
        }
        System.out.println(firstLocationOfEven);
    }

    /**
     *
     * @param n, the line
     * @param i, the i-th number of n line
     * @return the value at location (n, i)
     */
    private static long getValueOfLocation(int n, int i){
        /**
         * i=1 or i=2*n-1, value is 1
         * i<1 or i>2*n-1, value is 0
         * else should be calculated by up line
         */
        if((i ==1) || (i == 2*n -1)) return 1;
        else if((i < 1) || i > 2*n -1) return 0;
        else return getValueOfLocation(n - 1, i - 2)
                    + getValueOfLocation(n - 1, i - 1)
                    + getValueOfLocation(n - 1, i);
    }
}
