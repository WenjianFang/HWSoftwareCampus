/**
 * Created by Wenjian on 2017/1/11, 0011.
 */

import java.util.*;

/**
 * two array, combine them, sort them by ascend and delete repeat elements
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*First Array A*/
        int numOfArrayA = sc.nextInt();
        int[] arrayA = new int[numOfArrayA];
        for(int i = 0; i < numOfArrayA; i++){
            arrayA[i] = sc.nextInt();
        }
        /*Second Array B*/
        int numOfArrayB = sc.nextInt();
        int[] arrayB = new int[numOfArrayB];
        for(int i = 0; i < numOfArrayB; i++){
            arrayB[i] = sc.nextInt();
        }

        /*combined and sort array*/
        int[] combinedArray = getCombinedArray(arrayA, arrayB);
        for(int i = 0; i < combinedArray.length; i++){
            if(i == (combinedArray.length - 1))
                System.out.println(combinedArray[i]);/*last one*/
            else
                System.out.print(combinedArray[i]);/*middle ones*/
        }
    }

    /**
     *
     * @param arrayA, first array
     * @param arrayB, second array
     * @return, combined and sorted array
     */
    private static int[] getCombinedArray(int[] arrayA, int[] arrayB){
        List<Integer> list = new ArrayList<>();
        /*add two array to a list*/
        for(int i = 0; i < arrayA.length; i++){
            if(!list.contains(arrayA[i])) list.add(arrayA[i]);
        }
        for(int i = 0; i < arrayB.length; i++){
            if(!list.contains(arrayB[i])) list.add(arrayB[i]);
        }
        /*sort*/
        int[] combinedArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            combinedArray[i] = list.get(i);
        }
        Arrays.sort(combinedArray);

        return combinedArray;
    }
}
