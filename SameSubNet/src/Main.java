/**
 * Created by Wenjian on 2016/12/21, 0021.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Gvien netmask, and 2 ip
 * judge if 2 ip are the same subnet
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String maskString = sc.nextLine().toString();
        String ip1String = sc.nextLine().toString();
        String ip2String = sc.nextLine().toString();/*Given mask and ip strings*/

        int result = checkSameSubNet(maskString, ip1String, ip2String);

        System.out.println(result);
    }

    /**
     * string to array, mask & ip1 and mask & ip2 to judge
     * @param maskString
     * @param ip1String
     * @param ip2String
     * @return, 0 same subnet, 1 illegal ip, 2 not same subnet
     */
    private static int checkSameSubNet(String maskString, String ip1String, String ip2String){
        int[] mask = new int[4];
        int[] ip1 = new int[4];
        int[] ip2 = new int[4];/*mask, ip1, ip2 array*/

        if((!toIPArray(mask, maskString))||(!toIPArray(ip1, ip1String))||(!toIPArray(ip2, ip2String)))
            return 1;/*illegal ip*/

        int[] andArray = new int[4];/*& result of mask and ip1*/
        for(int i = 0; i < 4; i++){
            andArray[i] = mask[i] & ip1[i];/*ip1's sub net*/
        }
//        System.out.println(Arrays.toString(andArray));
        for(int i = 0; i < 4; i++){
            if(andArray[i] != (mask[i] & ip2[i])) return 2; /*different of & result, NOT same subnet*/
        }
        return 0;
    }

    /**
     * ip string to array, split should NOTICE that "." should be changed to "\\."
     * @param ip
     * @param ipString
     * @return, false illegal ip, true legal ip and transfer successful
     */
    private static boolean toIPArray(int[] ip, String ipString){
        String[] str = ipString.split("\\.");/*Escape Sequence, should use "\\"*/
        if(str.length != 4) return false; /*illegal ip*/

        for(int i = 0; i < str.length; i++){
            try {
                ip[i] = Integer.parseInt(str[i]);/*parse to integer*/
            }catch (Exception ex){/*format exception*/
                return false;
            }
            if((ip[i] < 0) || (ip[i] > 255)) return false;/*illegal ip range*/
        }
        return true;
    }
}
