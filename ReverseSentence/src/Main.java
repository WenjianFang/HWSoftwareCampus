/**
 * Created by Wenjian on 2017/2/28, 0028.
 */

import java.util.Scanner;

/**
 * Reverse the given sentence
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        String reversedSentence = reverseSentence(sentence);
        System.out.println(reversedSentence);
    }

    /**
     *
     * @param sentence
     * @return
     */
    private static String reverseSentence(String sentence) {
        /*first reverse the whole sentence*/
        StringBuilder reversedString = new StringBuilder(sentence);
        reverseString(reversedString, 0, reversedString.length() - 1);
        /*reverse each word*/
        int startIndex = 0;
        int endIndex = 0;
        int index = 0;
        while(index < reversedString.length()) {
            /*get a word's start and end index*/
            startIndex = index;
            while((index < reversedString.length()) && (reversedString.charAt(index) != ' ')) index++;
            endIndex = index - 1;
            /*reverse this word*/
            reverseString(reversedString, startIndex, endIndex);
            index ++;
        }
        return reversedString.toString();
    }

    /**
     *
     * @param reversedString
     * @param startIndex
     * @param endIndex
     */
    private static void reverseString(StringBuilder reversedString, int startIndex, int endIndex) {
        char tmpCh;
        while(startIndex < endIndex) {
            tmpCh = reversedString.charAt(startIndex);
            reversedString.setCharAt(startIndex, reversedString.charAt(endIndex));
            reversedString.setCharAt(endIndex, tmpCh);
            startIndex ++;
            endIndex --;
        }
    }
}
