/**
 * Created by Wenjian on 2017/1/10, 0010.
 */

import java.util.Scanner;

/**
 * Given two Big Integer, as String format
 * Output the their sum with String format
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*addend and augend number*/
        String addend = sc.next();
        String augend = sc.next();

        String sum = getSumOfBigIntegers(addend, augend);
        System.out.println(sum);
    }

    private static String getSumOfBigIntegers(String addend, String augend){
        /**
         * Add from the end of String
         * append the result to the StringBuilder
         * record the carry-bit
         */
        StringBuilder sum = new StringBuilder();/*sum of strings*/
        int carryBit = 0;/*record carry-bit*/
        /*index of addend and augend*/
        int iAddend = addend.length() - 1;
        int iAugend = augend.length() - 1;

        /*two string have characters*/
        while(iAddend >= 0 && iAugend >= 0){
            /*legal*/
            if((addend.charAt(iAddend) >= '0' && addend.charAt(iAddend) <= '9')
                    && (augend.charAt(iAugend) >= '0' && augend.charAt(iAugend) <= '9')){
                int tmp = (addend.charAt(iAddend) - '0') + (augend.charAt(iAugend) - '0') + carryBit;
                sum.append(tmp % 10);/*append the digit*/
                carryBit = tmp / 10;/*update the carry-bit*/
            }
            else{
                System.out.println("Illegal Numbers");
                return null;
            }
            iAddend --;
            iAugend --;
        }

        /*one string is out*/
        if(iAddend >= 0) {/*leave addend*/
            while (iAddend >= 0) {
                int tmp = (addend.charAt(iAddend) - '0') + carryBit;
                sum.append(tmp % 10);/*append the digit*/
                carryBit = tmp / 10;/*update the carry-bit*/
                iAddend--;
            }
        }
        else if(iAugend >= 0) {/*leave augend*/
            while (iAugend >= 0) {
                int tmp = (augend.charAt(iAugend) - '0') + carryBit;
                sum.append(tmp % 10);/*append the digit*/
                carryBit = tmp / 10;/*update the carry-bit*/
                iAugend--;
            }
        }
        if(carryBit > 0)/*finally if have carry-bit, it should be append*/
            sum.append(carryBit);
        return sum.reverse().toString();
    }
}
