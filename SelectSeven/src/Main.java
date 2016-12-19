/**
 * Created by Wenjian on 2016/12/19, 0019.
 */

import java.util.Scanner;

/**
 * loop, handle each number
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int relatedNumber = 7;/**/
        int count = 0;/*count the related numbers*/
        for(int i = 1; i < N; i++){
            if(isRelatedNumber(i, relatedNumber)) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     *
     * @param number, number which is going to be judge
     * @param relatedNumber, number which is related
     * @return true or false
     */
    private static boolean isRelatedNumber(int number, int relatedNumber){
        if(number % relatedNumber == 0) return true;/*times of relatedNumber, true*/
        else{/*each digits, whether is relatedNumber or not*/
            int tmp = number;
            while(tmp != 0){
                if(tmp % 10 == relatedNumber) return true;
                else tmp = tmp / 10;
            }
        }
        return false;
    }
}
