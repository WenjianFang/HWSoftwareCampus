/**
 * Created by Wenjian on 2017/1/2, 0002.
 */

import java.util.Scanner;

/**
 * Given a DNA sequence and length of subsequence
 * Obtain the sub-sequence that have largest GC-Ratio
 * GC-Ratio: Have most number of G and C
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String DNASeq = sc.next(); /*DNA Sequence*/
        int minLength = sc.nextInt(); /*minimum length sub-sequence*/

        double maxRatio = 0.0;
        String maxRatioSeq = "";
        /*Brute force method, it's complexity is O(n^2)*/
        for(int i = 0; i < (DNASeq.length() - minLength + 1); i++){/*start from 0->(length-minLength)*/
            for(int j = (i + minLength); j < DNASeq.length(); j++){/*start from minLength-1 -> end*/
                double ratio = getGCRatio(DNASeq.substring(i, j));
                if(ratio > maxRatio) {
                    maxRatio = ratio;
                    maxRatioSeq = DNASeq.substring(i, j);/*update ratio and seq*/
                }
            }
        }
        System.out.println(maxRatioSeq);
    }

    /**
     *
     * @param subSeq
     * @return
     */
    private static double getGCRatio(String subSeq){
        int count = 0; /*G/C count*/

        for(int i = 0; i < subSeq.length(); i++){
            if((subSeq.charAt(i) == 'G') || (subSeq.charAt(i) == 'C')) count++;
        }
        return (double)(count/(double)(subSeq.length()));
    }
}
