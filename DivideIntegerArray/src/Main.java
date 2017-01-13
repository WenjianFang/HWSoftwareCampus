/**
 * Created by Wenjian on 2017/1/13, 0013.
 */

import java.util.*;

/**
 * Given an integer array, divide it to 2 arrays,
 * the 5 times number should be at one array, and the 3 times number should be at one array
 * if it can be divide, just return true
 * else return false;
 */
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*array's length and the integer array*/
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i = 0; i < length; i++){
            array[i] = sc.nextInt();
        }
        boolean divideToTwoArray = checkWhetherCanDivide(array);
        System.out.println(divideToTwoArray);
    }

    /**
     *
     * @param array, the array to check
     * @return, can be divide or not
     */
    private static boolean checkWhetherCanDivide(int[] array){
        /**
         * there are many situations:
         * 1. the sum of the array is odd, it can not be divide anyway, just return false
         * 2. can be divided:
         * pin the (sumOfFive - sumOfThree) to the others array, divide this array to two equal sum array
         * this is an sub-set sum problem, it is a classic algorithmic problem
         */
        List<Integer> othersList = new ArrayList<>();/*list to record others number*/
        /*sum of three types of number*/
        int sumOfThree = 0;
        int sumOfFive = 0;
        int sumOfOthers = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 5 == 0) sumOfFive += array[i];
            else if(array[i] % 3 == 0) sumOfThree += array[i];
            else{/*calculate others numbers' sum and record this number*/
                sumOfOthers += array[i];
                othersList.add(array[i]);
            }
        }
        /*sum of all the numbers is odd, can not be divided*/
        if((sumOfFive + sumOfThree + sumOfOthers) % 2 != 0) return false;
        else{
//            if(sumOfFive - sumOfThree != 0) othersList.add(sumOfFive - sumOfThree);
            othersList.add(sumOfFive - sumOfThree);/*add the (sumOfFive - sumOfThree) to the list*/
            /*become a classic subset sum problem*/
            return divideToSameSumSublist(othersList);
        }
    }

    /**
     *
     * @param othersList, the list to be divide to 2 sublist that have the same sum
     * @return, can be divide or not
     */
    private static boolean divideToSameSumSublist(List<Integer> othersList){
        /**
         * 1. the sum of this list is odd, false
         * 2. this problem is the sub-set problem, from the list, choose a sub-list to achieve the sum is sumOfList/2.
         * this can use backtracking to solve
         */
        /*sum of list is odd, false*/
        int sumOfList = 0;
        for(int i = 0; i < othersList.size(); i++){
            sumOfList += othersList.get(i);
        }
        if(sumOfList % 2 != 0) return false;
        /*find the sub-set sum is sumOfList/2*/
        int target = sumOfList / 2;

        /**
         * Backtracking, recursively solve
         *
         */
        boolean haveSolution = subSetBacktracking(othersList, target);
        return haveSolution;
    }

    /**
     * sub-set sum problem
     * @param othersList, list of the whole set
     * @param target, the sum of sub-set
     * @return, can we find this sub-set
     */
    private static boolean subSetBacktracking(List<Integer> othersList, int target){
        Collections.sort(othersList);/*sort the list by ascending*/
        List<List<Integer>> solutions = new ArrayList<>();/*record all the solutions*/
        int[] solution = new int[othersList.size()];/*record the solution, 1 means selected, 0 means NO selected*/
        int currentSum = 0;/*current sum*/
        int iOfSolution = 0;/*solution's index, represents select which number*/
        /*call the recursive method*/
        subSetOfSumRecu(othersList, currentSum, iOfSolution, target, target * 2, solutions, solution);

        if(solutions.isEmpty()) return false;
        else{
//            System.out.println(solutions.toString());
            return true;
        }
    }

    /**
     *
     * @param list, the whole set
     * @param currentSum, current sum of the selected number
     * @param iOfsolution, the last selected number's index
     * @param target, the sub-set's sum
     * @param remain, the distance between current sum and the target
     * @param solutions, all solutions
     * @param solution, one solution
     */
    private static void subSetOfSumRecu(List<Integer> list, int currentSum, int iOfsolution, int target, int remain,
                                        List<List<Integer>> solutions, int[] solution){
        /*left child*/
        solution[iOfsolution] = 1;/*this number is selected*/
        if(currentSum + list.get(iOfsolution) == target){/*bingo, we find one solution*/
            /*add this solution to the all solutions*/
            List<Integer> oneSolution = new ArrayList<>();
            for(int i = 0; i <= iOfsolution; i++)
                oneSolution.add(solution[i]);
            solutions.add(oneSolution);
        }
        else if(iOfsolution + 1 < list.size()) {/*if there are exist numbers to be selected*/
            if (currentSum + list.get(iOfsolution) + list.get(iOfsolution + 1) <= target) {/*add next number can be less or equal than target*/
                /*go to next number, update the current sum with add current number and solution index, and the distance*/
                subSetOfSumRecu(list, currentSum + list.get(iOfsolution), iOfsolution + 1, target, remain - list.get(iOfsolution), solutions, solution);
            }
        }
        /*right child*/
        if(iOfsolution + 1 < list.size()) {
            if (currentSum + (remain - list.get(iOfsolution)) >= target && currentSum + list.get(iOfsolution + 1) <= target) {
                solution[iOfsolution] = 0;/*this number can not be selected*/
                /*go to next number*/
                subSetOfSumRecu(list, currentSum, iOfsolution + 1, target, remain - list.get(iOfsolution), solutions, solution);
            }
        }
    }

}
