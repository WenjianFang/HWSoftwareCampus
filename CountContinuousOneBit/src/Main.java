/**
 * Created by Wenjian on 2017/1/12, 0012.
 */

import java.util.Scanner;

/**
 * Given an integer number, count the max length of it's continuous 1 bits in its binary format
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*Given Integer number*/
        int num = sc.nextInt();
        /*get the binary display*/
        String binaryNum = getOtherDisplay(num, 2);
//        System.out.println(binaryNum);
        int maxContinuous = getMaxContinuousOneBit(binaryNum);
        System.out.println(maxContinuous);
    }

    private static int getMaxContinuousOneBit(String binaryNum){
        /**
         * traverse, and count 1 bit number, if meet 0, reset length
         */
        int currentLength = 0;
        int maxLength = 0;
        boolean lastIsOne = false;/*flag, whether last oen is 1 bit*/
        for(int i = 0; i < binaryNum.length(); i++){
            if(binaryNum.charAt(i) == '1') currentLength ++;
            else if(binaryNum.charAt(i) == '0'){
                if(currentLength > maxLength) maxLength = currentLength;/*update max length*/
                currentLength = 0;/*meet '0', current length reset*/
            }
        }
        if(currentLength > maxLength) maxLength = currentLength;/*final comparison*/
        return maxLength;
    }

    /**
     *
     * @param num, and integer number
     * @param display, the display format
     * @return, the display format represented as string
     */
    private static String getOtherDisplay(int num, int display){
        StringBuilder sb = new StringBuilder();/*record new display number*/
        if(num == 0){
            sb.append(0);
            return sb.toString();
        }
        while(num != 0){
            sb.append(num % display);
            num = num / display;/*update num*/
        }

        return sb.reverse().toString();
    }
}
