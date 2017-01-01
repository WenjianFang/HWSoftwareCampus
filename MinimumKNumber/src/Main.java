/**
 * Created by Wenjian on 2017/1/1, 0001.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Minimum K number
 * can use the partition method of quick sort
 * when the left part have k number, stop
 * But it might change the related location of numbers
 * and the OJ might check the order the the results
 * so the best idea is to sort the numbers
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); /*length of array*/
        int k = sc.nextInt(); /*minimum k numbers*/
        int[] numbers = new int[n]; /*numbers*/
        for(int i = 0; i < n; i++) numbers[i] = sc.nextInt();

        quickSort(numbers, 0, numbers.length - 1);/*it might change the original numbers's location*/

        for (int i = 0; i < k - 1; i++)
            System.out.print(numbers[i] + " ");
        System.out.println(numbers[k - 1]);
    }

    /**
     * quick sort numbers
     * @param numbers
     * @param start, quick sort from the start in numbers
     * @param end, quick sort to the end in numbers
     */
    private static void quickSort(int[] numbers, int start, int end){
        /*quick sort the numbers*/
        if(start < end){ /*larger than 1 elements*/
            int index = partition(numbers, start, end);/*pivot position*/
            quickSort(numbers, start, index - 1);/*left part quick sort*/
            quickSort(numbers, index + 1, end);/*right part quick sort*/
        }
    }

    /**
     *
     * @param array, array to be partition
     * @param start, partition range
     * @param end, partition range
     * @return, the pivot position
     * the array is partitioned, and left part less than pivot, and right part larger than pivot
     */
    private static int partition(int[] array, int start, int end){
        if(array.length == 0) return -1;/*array is null*/
        int pivot = array[end];/*end element as pivot*/
        int iLargerPivot = start;
        for(int i = start; i <= end; i++){
            if(array[i] < pivot){/*this element should be left of pivot*/
                if(i != iLargerPivot) swap(array, i, iLargerPivot);
                iLargerPivot++;
            }
        }
        swap(array, iLargerPivot, end);/*put the pivot to the right position*/
        return iLargerPivot;
    }

    /**
     * swap i and j number in the array
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j){
		/*exchange the element in i and j*/
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
