/**
 * Created by Wenjian on 2017/1/12, 0012.
 */

import java.util.Scanner;

/**
 * Given a string, check whether it is a legal ip or not
 * For this program, there are no specify principles to define the legal ip
 * So, here, we just check there have four parts with split "." and each part is an integer in [0, 255]
 * Others are illegal ip
 * In reality, the ip contains 0 and 255 might be illegal for general PC
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*IP string*/
        String ipString = sc.next();

        if (checkLegalIp(ipString)) System.out.println("YES");
        else System.out.println("NO");
    }

    /**
     *
     * @param ipString, the Given ip string
     * @return, if the ip is legal, return true, else return false;
     */
    private static boolean checkLegalIp(String ipString){
        /*split the ip string, the "." is an escape sequence, should use "\\"*/
        String[] ipStrings = ipString.split("\\.");

        /*the legal ip should have 4 parts*/
        if(ipStrings.length != 4) return false;
        /*for each part, the integer should be in [0, 255]*/
        for(int i = 0; i < ipStrings.length; i++){
            if(ipStrings[i] == null) return false;
            try{/*Integer.parseInt() would throw exception if the string is illegal integer*/
                if(Integer.parseInt(ipStrings[i]) < 0 || Integer.parseInt(ipStrings[i]) > 255) return false;
            }catch (Exception ex){
                return false;/*illegal integer*/
            }
        }
        return true;/*finally, nothing wrong, it is true*/
    }
}
