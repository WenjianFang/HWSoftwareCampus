/**
 * Created by Wenjian on 2017/1/11, 0011.
 */

import java.util.Scanner;

/**
 * Given two string, define sequence actions to change the strings to be equal
 * First: replace, for instance, replace "a" with "b";
 * Second: add, for instance, add "e" change "abdd" to "aebdd";
 * Third: delete, for instance, delete "l", change "travelling" to "traveling"
 * define the time of action to change the strings to be equal as distance
 * the similarity is define as 1/distance
 *
 * For this problem, we use the Dynamic Programming as Longest Common Subsequence
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*two strings*/
        String stringA = sc.next();
        String stringB = sc.next();

        /**/
        int distance = getDistanceOfTwoString(stringA, stringB);
        System.out.println("1/" + (distance + 1));/*1/(distance+1) is the similarity*/
    }

    private static int getDistanceOfTwoString(String stringA, String stringB){
        /**
         * Dynamic Programming, use distance[i][j] to represent distance of stringA[0->i] and stringB[0->j]
         * if have the same character, distance NOT change, distance[i][j] = distance[i-1][j-1];
         * if NOT have the same character, there are 3 actions:
         * Replace: replace stringA or stringB, distance[i][j] = distance[i-1][j-1] + 1;
         * Add and Delete: add to stringA OR delete stringB, distance[i][j] = distance[i][j-1] + 1;
         *                 delete stringA OR add to stringB, distance[i][j] = distance[i-1][j] + 1;
         */

        int[][] distance = new int[stringA.length()][stringB.length()];
        /*initialization*/
//        for(int i = 0; i < stringA.length(); i++) distance[i][0] = 0;
//        for(int j = 0; j < stringB.length(); j++) distance[0][j] = 0;
        /**/
        for(int i = 0; i < stringA.length(); i++){
            for(int j = 0; j < stringB.length(); j++){
                //if(i == 0 || j == 0) ;/*do nothing, because this has been initialized*/
                if(stringA.charAt(i) == stringB.charAt(j)){
                    if(i == 0 || j == 0){/*equal, but one string is the head*/
                        if(i == 0) distance[i][j] = j;/*should delete or add j characters*/
                        else distance[i][j] = i;/*should delete or add i characters*/
                    }
                    else distance[i][j] = distance[i - 1][j - 1]; /*distance is 0*/
                }
                else{/*distance is minimum of three situation*/
                    if(i == 0 || j == 0){/*unequal, but one string is the head*/
                        if(i == 0 && j == 0) distance[i][j] = 1;/*both head*/
                        else if(i == 0) distance[i][j] = distance[i][j - 1] + 1;/*one is head*/
                        else distance[i][j] = distance[i - 1][j] + 1;/*the other one head*/
                    }
                    else
                        distance[i][j] = Math.min(Math.min(distance[i - 1][j - 1], distance[i - 1][j]), distance[i][j - 1]) + 1;
                }
            }
        }
        return distance[stringA.length() - 1][stringB.length() - 1];
    }
}
