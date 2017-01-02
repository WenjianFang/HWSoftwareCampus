/**
 * Created by Wenjian on 2017/1/2, 0002.
 */

import java.util.Scanner;

/**
 * M apples put N plates
 * how many methods to put apples
 * 1,1,5 and 1,5,1 are the same put method
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numOfApples = sc.nextInt(); /*apples*/
        int numOfPlates = sc.nextInt(); /*plates*/

        int methods = countPutMethods(numOfApples, numOfPlates);
        System.out.println(methods);
    }

    /**
     * Divide to two parts, use recursively method to solve
     * @param numOfApples, apples's number
     * @param numOfPlates, plates's number
     * @return, the put methods of these apples' number and plates's number
     */
    private static int countPutMethods(int numOfApples, int numOfPlates){
        /**
         * this can be divided to 2 parts
         * first part: every plates have at least one apple, so left (numOfApples - numOfPlates) apples to put
         * second part: at least one plate have zero apple, so left numOfApples apples and (numOfPlates - 1) plates to put
         * Stop condition: numOfApples = 0 OR numOfPlates = 1, there is exist only one put method
         */
        if((numOfApples < 0) || (numOfPlates < 1)) return 0; /*NO solution*/
        if((numOfApples == 0) || (numOfPlates == 1)) return 1; /*only one put method*/

        return countPutMethods(numOfApples - numOfPlates, numOfPlates)
                + countPutMethods(numOfApples, numOfPlates - 1); /*two parts*/
    }
}
