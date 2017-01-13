/**
 * Created by Wenjian on 2017/1/13, 0013.
 */

import java.util.Scanner;

/**
 * Given a double number
 * transfer it to the chinese yuan with chinese unit
 * 壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整
 */
public class Main {
    static final char[] digit = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    static final char ten = '拾';
    static final char hundred = '佰';
    static final char thousand = '仟';
    static final char tenThousand = '万';
    static final char hundredMillion = '亿';
    static final char[] unit = {'分', '角', '元'};
    static final char exact = '整';
    static final String RMB = "人民币";

    static final long tenNum = 10;
    static final long hundredNum = 100;
    static final long thousandNum = 1000;
    static final long tenThousandNum = 10000;
    static final long hundredMillionNum = 100000000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();/*the money*/

        transferToChinese(number);
    }

    private static void transferToChinese(double number){
        /*record the chinese*/
        StringBuilder sb = new StringBuilder();
//        StringBuilder decimalSB = new StringBuilder();
        /*split to get the intger and the decimal*/
        sb.append(RMB);
        long integerPart = (long) number;
        double decimalPart = number - integerPart;
//        System.out.println(integerPart + " " + decimalPart);
        /*transfer*/
        if(decimalPart == 0.0){/*no decimal, it is exact full yuan*/
            sb.append(transferIntegerPart(integerPart));
            sb.append(unit[2]);
            sb.append(exact);
        }
        else if(integerPart == 0) sb.append(transferDecimalPart(decimalPart)); /*no integer part*/
        else {/*have integer and have decimal*/
            sb.append(transferIntegerPart(integerPart));
            sb.append(unit[2]);
            sb.append(transferDecimalPart(decimalPart));
        }
        System.out.println(sb.toString());
    }

    private static String transferIntegerPart(long integerPart){
        StringBuilder sb = new StringBuilder();
        if(integerPart == 0.0){/*zero*/
            sb.append(digit[0]);
            return sb.toString();
        }
        /*others*/
        if(integerPart >= hundredMillionNum){/*larger than hundred million*/
            sb.append(transferIntegerPart(integerPart / hundredMillionNum));
            sb.append(hundredMillion);
            /*have remaining*/
            if(integerPart % hundredMillionNum != 0){
                if((integerPart % hundredMillionNum) < (hundredMillionNum / 10)) sb.append(digit[0]);
                sb.append(transferIntegerPart(integerPart % hundredMillionNum));
            }
        }
        else if(integerPart >= tenThousandNum) {/*larger than ten thousand*/
            sb.append(transferIntegerPart(integerPart / tenThousandNum));
            sb.append(tenThousand);
            if(integerPart % tenThousandNum != 0){/*have remainning*/
                /*<100, should add "零"*/
                if((integerPart % tenThousandNum) < (tenThousandNum / 10)) sb.append(digit[0]);
                sb.append(transferIntegerPart(integerPart % tenThousandNum));
            }
        }
        else if(integerPart >= thousandNum) {/*larger than one thousand*/
            sb.append(transferIntegerPart(integerPart / thousandNum));
            sb.append(thousand);
            if(integerPart % thousandNum != 0) {
                if((integerPart % thousandNum) < (thousandNum / 10)) sb.append(digit[0]);
                sb.append(transferIntegerPart(integerPart % thousandNum));
            }
        }
        else if(integerPart >= hundredNum) {/*larger than one hundred*/
            sb.append(transferIntegerPart(integerPart / hundredNum));
            sb.append(hundred);
            if(integerPart % hundredNum != 0){
                if((integerPart % hundredNum) < (hundredNum / 10)) sb.append(digit[0]);
                sb.append(transferIntegerPart(integerPart % hundredNum));
            }
        }
        else if(integerPart >= tenNum) {/*larger than one thousand*/
            if(integerPart / tenNum > 1) sb.append(transferIntegerPart(integerPart /tenNum));
            sb.append(ten);
            if(integerPart % tenNum != 0) sb.append(transferIntegerPart(integerPart % tenNum));
        }
        else if((int)integerPart > 0) sb.append(digit[(int)integerPart]);
        //sb.append(unit[2]);/*add "元"*/
        return sb.toString();
    }

    private static String transferDecimalPart(double decimalPart){
        StringBuilder sb = new StringBuilder();
        int decimalToInteger = (int)((decimalPart + 0.001) * 100);/*to be an integer*/
        if(decimalToInteger >= tenNum){/*larger than 10 jiao*/
            sb.append(digit[decimalToInteger / (int)tenNum]);
            sb.append(unit[1]);
            decimalToInteger = decimalToInteger % (int)tenNum;
        }
        if(decimalToInteger != 0){
            sb.append(digit[decimalToInteger]);
            sb.append(unit[0]);
        }
        return sb.toString();
    }
}
