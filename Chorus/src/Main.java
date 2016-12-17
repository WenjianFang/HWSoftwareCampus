/**
 * Created by Wenjian on 2016/12/17, 0017.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given several students' height, at least eliminate how many students,
 * remaining students can be queue as chorus queue.
 * Chorus queue, T1<T2<...<Ti-1<Ti>Ti+1>...>Tk
 *
 * Find the ascend subsequence and descend subsequence->time complexity O(n^2)
 * each student as middle one, plus left sub and right sub -> longest chorus queue
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[N];

        /*Get the students' height*/
        for (int i = 0; i < height.length; i++)
            height[i] = sc.nextInt();

        /*Get eliminate students number*/
        int result = atLeastNumber(height);
        System.out.println(result);
    }

    private static int atLeastNumber(int[] height){

        /*Get length of each longest subsequence by ascend/descend of the height list*/
        int[] ascend = getLongestSub(height, "ascend");
        int[] descend = getLongestSub(height, "descend");

        int max = 0;
        for(int i = 0; i < height.length; i++){/*this student as middle one*/
            if(max < (ascend[i] + descend[i] - 1))
                max = ascend[i] + descend[i] - 1;/*maximum chorus queue*/
        }
        return height.length-max;/*eliminate number*/
    }

    /**
     *
     * @param height, students height list
     * @param type, ascend subsequence or descend subsequence
     * @return length of longest order subsequece when arrive at each student
     */
    private static int[] getLongestSub(int[] height,String type){
        int[] ret = new int[height.length];
        if(type.equals("ascend")){
            for(int i = 0; i < height.length; i++){
                ret[i] = 1;/*length at least 1 from 0->i*/
                for(int j = 0; j < i; j++){
                    /**
                     * j-th number < i-th number, the length should be plus 1,
                     * if this new length > old length
                     */
                    if((height[j] < height[i])&&(ret[i] < ret[j] + 1)){
                        ret[i] = ret[j] + 1;
                    }
                }
            }
        }
        else if(type.equals("descend")){
            for(int i = height.length - 1; i >= 0; i--){
                ret[i] = 1;
                for(int j = height.length - 1; j > i; j--){
                    if((height[j] < height[i])&&(ret[i] < ret[j] + 1)){
                        ret[i] = ret[j] + 1;
                    }
                }
            }
        }
        return ret;
    }
}
