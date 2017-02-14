/**
 * Created by Wenjian on 2017/2/14, 0014.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of numbers, sort them and delete the repeat numbers
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); /*how many random numbers*/
        /*the random numbers*/
        List<Integer> array = new ArrayList<>();
        for(int i = 0; i < n; i++) array.add(sc.nextInt());

        List<Integer> handledArray = deleteRepeatAndSortArray(array);
        /*print*/
        for(int i = 0; i < handledArray.size(); i++) System.out.println(handledArray.get(i));
    }

    /**
     *
     * @param array, the original array to be handled
     * @return, return the handled array
     */
    private static List deleteRepeatAndSortArray(List<Integer> array){
        /**
         * use space to obtain O(n) time complexity
         */
        Collections.sort(array);/*sort the array*/
        List<Integer> handledArray = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){/*traverse the array, if repeat, do not add to the new array*/
            if(!handledArray.contains(array.get(i))) handledArray.add(array.get(i));
        }
        return handledArray;
    }
}
