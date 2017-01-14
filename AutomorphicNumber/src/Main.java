/**
 * Created by Wenjian on 2017/1/14, 0014.
 */

import java.util.Scanner;

/**
 * judge whether a number is an automorphic number or not
 * count the number in an range
 *
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*range upper bound*/
        int rangeUp = sc.nextInt();
        /*count*/
        int count = countAutomorphicNumbers(rangeUp);
        System.out.println(count);
    }

    /**
     *
     * @param rangeUp, from the range[0, rangeUp], we count the automorphic numbers
     * @return, the count result
     */
    private static int countAutomorphicNumbers(int rangeUp){
        if(rangeUp < 0) return 0;/*less than 0, no one*/
        /*traverse and count*/
        int count = 0;
        for(int i = 0; i <= rangeUp; i++){
            if(isAutoNum(i)){
//                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    /**
     * check whether the given number is an automorphic number or not
     * @param num, to be checked number
     * @return, return the boolean result
     */
    private static boolean isAutoNum(int num){
        /**
         * judge whether a number is an automorphic number
         */
        /*transfer to string*/

        String squareString = String.valueOf((long)(num) * (long)(num));
        String originalString = String.valueOf((long)(num));
        /*judge*/
//        System.out.println(squareString + " and " + originalString);
        if(originalString.equals(squareString.substring(squareString.length() - originalString.length()))) return true;
        else return false;
    }
}
