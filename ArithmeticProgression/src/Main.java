/**
 * Created by Wenjian on 2017/1/14, 0014.
 */

import java.util.*;

/**
 * Given a range, find the arithmetic progression that have max length, the elements should be prime
 * First, get the prime numbers array from this range
 * Second, classic problem find the max length arithmetic progression from a given array
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*array range*/
        int min = sc.nextInt();
        int max = sc.nextInt();

        /*get the prime array*/
        int[] prime = getPrimeArray(min, max);

//        System.out.println(Arrays.toString(prime));
        /*get the arithmetic progression that have max length and max diff*/
        int[] ap = getAPMaxLengthMaxDiff(prime);
        /*print*/
//        System.out.println(Arrays.toString(ap));
        /*as required, should be printed one number one line*/
        for(int i = 0; i < ap.length; i++) System.out.println(ap[i]);
    }

    /**
     *
     * @param array
     * @return
     */
    private static int[] getAPMaxLengthMaxDiff(int[] array){
        /*here the array is already sort, but other places might not be sorted, so first sort it*/
        Arrays.sort(array);
        /**
         * Brute Force, for each number as first, and his last as second number, and diff = second-first
         */
        if(array.length <= 2) return array; /*only have 2 number or not*/
        /*ap that have max length and max diff*/
        int maxLength = 0;
        int maxStart = array[0];
        int maxDiff = 0;
        /**/
        for(int i = 0; i < array.length - 1; i++){/*first element*/
            for(int j = i + 1; j < array.length; j++){/*second element*/
                int length = 2; /*current length*/
                int diff = array[j] - array[i];/*current diff*/
                int start = array[i];/*current start*/
                /**/
                int lastOne = array[j];/*ap's last one*/
                for(int k = j + 1; k < array.length; k++){
                    if(array[k] == lastOne + diff) {/*the ap's number*/
                        lastOne = array[k];/*last one updates to array[k]*/
                        length ++; /*increase the length*/
                    }
                }
                /*the length is larger than max length*/
                if(length > maxLength){
                    maxStart = start;
                    maxLength = length;
                    maxDiff = diff;
                }
                /*the same length, if the diff is larger, also update*/
                else if((length == maxLength)&&(diff > maxDiff)){
                    maxStart = start;
                    maxLength = length;
                    maxDiff = diff;
                }
            }
        }
        /*construct ap*/
        int[] ap = new int[maxLength];
        int iOfAP = 0;
        ap[iOfAP] = maxStart;
        for(int i = 0; i < array.length; i++){
            if(array[i] == ap[iOfAP] + maxDiff){
                iOfAP ++;
                ap[iOfAP] = array[i];
            }
        }
        return ap;
    }
    /**
     *
     * @param min
     * @param max
     * @return
     */
    private static int[] getPrimeArray(int min, int max){
        /**
         * from 2-> sqrt(num), can not be divide, it is prime
         */
        /*prime array and its index*/
        List<Integer> prime = new ArrayList<>();
        /*start traverse*/
        for(int i = min; i <= max; i++){
            if(isPrime(i)){/*is a prime, add*/
                prime.add(i);
            }
        }
        int[] primeArray = new int[prime.size()];
        for(int i = 0; i < primeArray.length; i++) primeArray[i] = prime.get(i);
        return primeArray;
    }

    /**
     *
     * @param num
     * @return
     */
    private static boolean isPrime(int num){
        if(num <= 1) return false;/*<=1 not prime*/
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;/*can be divide, not a prime*/
        }
        return true;
    }
}
