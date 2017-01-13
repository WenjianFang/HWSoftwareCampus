/**
 * Created by Wenjian on 2017/1/13, 0013.
 */
import java.util.Scanner;

/**
 * Given the candidates and the votes
 * count the candidates with its vote number
 * For this problem, use Map is a good solution, and it might be easy
 * But as reply in the community, there would exist duplicate name, and the duplicate name should also be display
 * But the vote number is 0
 * So the Map might be not a good idea
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*number of candidates*/
        int numOfCandidates = sc.nextInt();
        /*candidates*/
        String[] candidates = new String[numOfCandidates];
        for(int i = 0; i < numOfCandidates; i++) candidates[i] = sc.next();
        /*number of votes*/
        int numOfVotes = sc.nextInt();
        /*votes*/
        String[] votes = new String[numOfVotes];
        for(int i = 0; i < numOfVotes; i++) votes[i] = sc.next();

        countVotes(candidates, votes);
    }

    private static void countVotes(String[] candidates, String[] votes){
        /**
         * Brute Force
         */
        /*record the count result*/
        int[] countResult = new int[candidates.length];
        for(int i = 0; i < countResult.length; i++) countResult[i] = 0;/*initialization*/
        int invalid = 0;
        /*start count*/
        for(int i = 0; i < votes.length; i++){
            boolean valid = false;/*record the vote is valid or not*/
            for(int j = 0; j < candidates.length; j++){
                if(votes[i].equals(candidates[j])){/*this candidate*/
                    valid = true;
                    countResult[j]++;
                    break;/*vote increase and break, for the sake of the same name*/
                }
            }
            if(!valid) invalid++;
        }

        /*print them*/
        for(int i = 0; i < candidates.length; i++){
            System.out.println(candidates[i] + " : " + countResult[i]);
        }
        System.out.println("Invalid : " + invalid);
    }
}
