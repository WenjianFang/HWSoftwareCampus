/**
 * Created by Wenjian on 2017/2/27, 0027.
 */

import java.util.Scanner;

/**
 * Give an float number, output it's approximate number
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float floatNum = sc.nextFloat();

        int integerNum = getIntegerNum(floatNum);

        System.out.println(integerNum);

        //System.out.println(Math.round(floatNum));
    }

    /**
     *
     * @param floatNum
     * @return
     */
    private static int getIntegerNum(float floatNum) {
         /*change to be non-negative number*/
        int signal = 1;
        if(floatNum < 0.0) {
            signal = -1;
            floatNum = -floatNum;
        }
        /*result = base + carry*/
        int base = (int) floatNum;

        /**
         * 5.1 -> 5 + 0
         * -5.1 -> -(5 + 0)
         * 5.6 -> 5 + 1
         * -5.6 -> -(5 + 1)
         * 5.5 -> 5 + 1
         * -5.5 -> -(5 + 0)
         */
        int carry = 0;
        if(signal == 1) {
            carry = (floatNum - base) >= 0.5 ? 1 : 0;
        }
        else {
            carry = (floatNum - base) > 0.5 ? 1 : 0;
        }
        return signal * (base + carry);
    }
}
