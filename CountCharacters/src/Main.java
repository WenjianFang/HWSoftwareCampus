/**
 * Created by Wenjian on 2017/2/28, 0028.
 */

import java.util.Scanner;

/**
 * Given a string, count how many different characters
 */
public class Main {
    final static int ASCII_NUM = 128;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        int diffCharactersNum = countDiffCharacterNum(inputString);
        System.out.println(diffCharactersNum);
    }

    /**
     *
     * @param inputString
     * @return
     */
    private static int countDiffCharacterNum(String inputString) {
        /*0-127*/
        int[] characters = new int[ASCII_NUM];
        for(int i = 0; i < ASCII_NUM; i++) {
            characters[i] = 0;
        }
        /*count each characters' number*/
        for(int i = 0; i < inputString.length(); i++) {
            characters[(int)inputString.charAt(i)] ++;
        }

        /*traverse the array*/
        int count = 0;
        for(int i = 0; i < ASCII_NUM; i++) {
            if(characters[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
