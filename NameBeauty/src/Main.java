/**
 * Created by Wenjian on 2016/12/18, 0018.
 */

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * Given several names, calculate name beauty of each name
 */
public class Main {
    final static int CHARACTER_NUM = 26;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfName = Integer.parseInt(sc.nextLine().toString());/*here in Java, it is not used*/
        //String[] names = sc.nextLine().split(" ");/*get each name*/

        String[] names = new String[numberOfName];
        for(int i = 0; i < numberOfName; i++) names[i] = sc.nextLine().toString();
        for(int i = 0; i < names.length; i++){
            int maxBeauty = getMaxBeauty(names[i]);/*calculate max beauty*/
            System.out.println(maxBeauty);
        }
    }

    /**
     *
     * @param name, original name
     * @return beauty
     * Just statistic each character and sort the frequency of each character, so the time complexity is O(n)
     */
    private static int getMaxBeauty(String name){
        String lowCaseName = name.toLowerCase(Locale.ENGLISH);
        //String lowCaseName = name;
        int[] chs = new int[CHARACTER_NUM];/*store the frequency of each character*/
        for(int i = 0; i < CHARACTER_NUM; i++) chs[i] = 0;/*initialization*/

        for(int i = 0; i < lowCaseName.length(); i++){
            chs[lowCaseName.charAt(i) - 'a'] = chs[lowCaseName.charAt(i) - 'a'] + 1;/*Obtain the frequency*/
        }

        Arrays.sort(chs);/*sort the frequency of characters*/
        int result = 0;
        for(int i = CHARACTER_NUM - 1; i >= 0; i--){
            if(chs[i] > 0) result = result + chs[i] * (i+1);/*multi-ply its beauty weight*/
            else break;
        }
        return result;
    }
}
