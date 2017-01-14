/**
 * Created by Wenjian on 2017/1/14, 0014.
 */

import java.util.*;

/**
 * statistics the English characters, number characters and blank characters
 * sort them, if the count is the same, by the ASCII to sort
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*the string to be statistic*/
        String str = sc.nextLine();

        /*two arrays to record the characters and the statistics*/
        int n = 256;/*ascii*/
        Character[] characters = new Character[n];
        Integer[] statistics = new Integer[n];
        for(int i = 0; i < statistics.length; i++){
            characters[i] = (char)i;
            statistics[i] = 0; /*initialization*/
        }
        /*traverse*/
        for(int i = 0; i < str.length(); i++){
            if((str.charAt(i) >= '0' && str.charAt(i) <= '9')
                || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                || (str.charAt(i) == ' ')){
                statistics[str.charAt(i)]++;
            }
        }

        /*sort and print*/
        sortAndPrint(characters, statistics);
    }

    private static void sortAndPrint(Character[] characters, Integer[] statistics){
        /**
         * use a simple sort algorithm, and swap characters and statistics simultaneously
         */
        /*insert sort*/
        for(int i = 1; i < characters.length; i++){
            for(int j = i; j > 0; j--){
                if(statistics[j] > statistics[j - 1]){
                    swap(characters, j, j - 1);
                    swap(statistics, j, j - 1);
                }
                else if((statistics[j] == statistics[j - 1]) && (characters[j] < characters[j - 1])){
                    swap(characters, j, j - 1);
                    swap(statistics, j, j - 1);
                }
                else break;
            }
        }

        /*print*/
        for(int i = 0; i < statistics.length; i++){
            if(statistics[i] == 0) break;
            else System.out.print(characters[i]);
        }
        System.out.println();
    }

    private static <T> void swap(T[] array, int i, int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
