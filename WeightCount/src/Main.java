/**
 * Created by Wenjian on 2016/12/28, 0028.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * input: n, number of group; weight, weight of n group; num, number of each group
 * how many weight can be balance
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*input*/
        int numOfGroup = sc.nextInt();
        int[] weightOfEachGroup = new int[numOfGroup];
        int[] numOfEachGroup = new int[numOfGroup];

        for(int i = 0; i < numOfGroup; i++){
            weightOfEachGroup[i] = sc.nextInt();
        }
        for(int i = 0; i < numOfGroup; i++){
            numOfEachGroup[i] = sc.nextInt();
        }

        /*get weight count*/
        int count = getWeightCount(weightOfEachGroup, numOfEachGroup);
        System.out.println(count);
    }

    /**
     *
     * @param weightOfEachGroup, weight of each group
     * @param numOfEachGroup, number of each group
     * @return weight count
     * For each group, calculate the count
     */
    private static int getWeightCount(int[] weightOfEachGroup, int[] numOfEachGroup){
        Set<Integer> allWeight = new HashSet<>();
        allWeight.add(0);
        for(int i = 0; i < weightOfEachGroup.length; i++){
            getWeightCountEachGroup(weightOfEachGroup, numOfEachGroup, i, allWeight);/*count each group*/
        }
        //System.out.println(allWeight.toString());
        return allWeight.size();
    }

    /**
     *
     * @param weightOfEachGroup
     * @param numOfEachGroup
     * @param index, indicates which group
     * @param allWeight, store all the weight candidates.
     * Assume add one weight, calculate the allWeight
     */
    private static void getWeightCountEachGroup(int[] weightOfEachGroup, int[] numOfEachGroup, int index, Set<Integer> allWeight){
        while(numOfEachGroup[index] > 0) {
            numOfEachGroup[index]--; /*minus the number of this group*/

            Iterator<Integer> it = allWeight.iterator(); /*all weight iterator*/
            Set<Integer> currentWeight = new HashSet<>(); /*store the weight would be add in this time*/
            if (!allWeight.contains(weightOfEachGroup[index])) currentWeight.add(weightOfEachGroup[index]);/*add this weight*/
            while (it.hasNext()) {
                int current = it.next() + weightOfEachGroup[index];/*plus the exist weight, if it is new weight, add*/
                if ((!allWeight.contains(current)) && (!currentWeight.contains(current))) currentWeight.add(current);
            }
            /*in the currentWeight set are all fresh, should be add to allWeight*/
            allWeight.addAll(currentWeight);
        }
    }
}
