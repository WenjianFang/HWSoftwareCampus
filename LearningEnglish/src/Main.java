import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Wenjian on 2016/12/28, 0028.
 */

/**
 * Transfer a long integer to a English string
 */
public class Main {

    /*unit array*/
    static String[] unit = {"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] unitOver = {"Error", "Error", "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"};

    static long billion = 1000000000;
    static long million = 1000000;
    static long thousand = 1000;
    static long hundred = 100;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            long num = sc.nextLong();/*get a long number*/
            String englishString = transferFromLongToString(num);
            System.out.println(englishString);
        }catch (Exception ex){
            System.out.println("error");/*illegal input*/
            return;
        }
    }

    /**
     *
     * @param num, long num
     * @return, English string
     */
    private static String transferFromLongToString(long num){
        /**
         * corresponding English word
         * here we do not use StringBuilder to append, because of the "blank" problem is complex
         */
        List<String> enList = new ArrayList<>();
        /*transfer*/
        if(num == 0) return "zero";
        if(num < 0) return "error";/*should greater than 0*/
        /*handle larger than 1 billion*/
        if(num >= billion){
            enList.addAll(transferUnit(num / billion, false));/*transferUnit handle the part that larger than billion*/
            enList.add("billion");
            num = num % billion;
        }
        /*handle larger than 1 million*/
        if(num >= million){
            enList.addAll(transferUnit(num / million, false));/*transferUnit handle the part that larger than million*/
            enList.add("million");
            num = num % million;
        }
        /*handle larger than 1 thousand*/
        if(num >= thousand){
            enList.addAll(transferUnit(num / thousand, false));/*transferUnit handle the part that larger than thousand*/
            enList.add("thousand");
            num = num % thousand;
        }
        /*handle less than 1 thousand*/
        if(num < thousand){
            enList.addAll(transferUnit(num, true));/*transferUnit handle the part that less than thousand*/
        }
        //System.out.println(enList.toString());

        /*from list to string*/
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < enList.size() - 1; i++){
            sb.append(enList.get(i)).append(" ");
        }
        sb.append(enList.get(enList.size()-1));
        return sb.toString();
    }

    /**
     *
     * @param num, long num
     * @return, word list
     * transfer num less than thousand
     */
    private static List transferUnit(long num, boolean last){
        List<String> enList = new ArrayList<>();
        /*handle larger than hundred*/
        if(num >= hundred){
            enList.add(unit[(int)(num / hundred)]);/*transferUnit handle the part that larger than hundred*/
            enList.add("hundred");
            /*add "and" if there are last part's word*/
            if((num % hundred != 0) && last) enList.add("and");
        }
        /*handle less than hundred*/
        num = num % hundred;
        if(num != 0){
            if(num >= 20){
                enList.add(unitOver[(int)(num / 10)]);
                if(num % 10 != 0) {
                    /*add bland if there are follow word*/
                    enList.add(unit[(int)(num % 10)]);
                }
            }
            else{/*less than 20, add*/
                enList.add(unit[(int)(num)]);
            }
        }
        return enList;
    }
}

