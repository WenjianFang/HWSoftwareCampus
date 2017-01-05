/**
 * Created by Wenjian on 2017/1/3, 0003.
 */

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.*;

/**
 * Given 4 numbers, range [1, 10]
 * use +, -, *, / to combination them to get 24
 * If exist this +, -, *, /, return true, else false
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 4; /*four numbers*/
        int[] num = new int[4];
        for(int i = 0; i < n; i++) num[i] = sc.nextInt();

        /*get permutation of given numbers*/
        List<List<Integer>> allPer = new ArrayList<>();
        getPermutation(num, 0, allPer, null);
        boolean twentyFourPoint = false;
        for(int i = 0; i < allPer.size(); i++) {/*each permutation*/
            if(checkTwentyFourPoint(allPer.get(i))){
                twentyFourPoint = true;
                break;
            }
        }
        System.out.println(twentyFourPoint);
    }

    /**/
    private static boolean checkTwentyFourPoint(List<Integer> num){
        /*expression's characters map*/
        char[] characterMap = {'+', '-', '*', '/'};
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    /*three expression characters*/
                    StringBuilder exp = new StringBuilder();/*expression string*/
                    exp.append(num.get(0)).append(characterMap[i]);
                    exp.append(num.get(1)).append(characterMap[j]);
                    exp.append(num.get(2)).append(characterMap[k]);
                    exp.append(num.get(3));
                    if(getExpressionValue(exp.toString()) == 24.0){/*use javax to calculate string expression*/
                        System.out.println(exp.toString());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**/
    private static double getExpressionValue(String exp){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = null;
        try {
            result = engine.eval(exp);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        if(result instanceof Double) return ((Double) result);
        else return (Integer) result;
    }
    /**
     *
     * @param num, array which is to be permutationed
     * @param start, the permutation range from start index of array to the end
     * @return, all permutations
     */
    private static void getPermutation(int[] num, int start, List<List<Integer>> allPer, List<Integer> parentPer){
        /**
         * Recursive method
         * First: get one element put the first position, left recursively call this method
         * Second: change the first element, and left recursively call the method
         */

        /*stop condition, start is the end, there is no element to permutation*/
        if(start == num.length){
            allPer.add(parentPer);
            return; /*recursive method stop*/
        }
        for(int i = start; i < num.length; i++){
            List<Integer> onePer = new ArrayList<>();
            if(parentPer != null) onePer.addAll(parentPer);/*add former elements*/
            onePer.add(num[i]);/*add current element*/

            swap(num, i, start);/*i-th element is positioned at the start*/

            getPermutation(num, start + 1, allPer, onePer);

            swap(num, i, start); /*swap back to the original*/
        }
    }

    /**
     * swap the i-th element and j-th element in the array
     * @param num
     * @param i
     * @param j
     */
    private static void swap(int[] num, int i, int j){
        if(num == null) return;
        if(i < 0 || j < 0 || i > num.length || j > num.length) return;
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
