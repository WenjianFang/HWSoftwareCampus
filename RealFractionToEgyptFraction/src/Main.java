/**
 * Created by Wenjian on 2017/1/11, 0011.
 */

import java.util.Scanner;

/**
 * Given a Real Fraction, convert to Egypt fraction
 * This might be several result, I do not know which one the Huawei want
 * From Internet, Fibonacci Greedy Algorithm:
 * First: q = b/a, r = b%a;
 * Second: a/b = 1/(q+1) + (a-r)/(b(q+1)), can be proof
 * loop second until the last item is Egypt fraction
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*real fraction, string format*/
        String realFraction = sc.next();

        /*Egypt fraction sequence*/
//        String egyptFraction = getEgyptFractionWithGreedy(realFraction);
//        String egyptFraction = getEgyptFractionWithBruteForce(realFraction);
        String egyptFraction = getEgyptFractionWithSpecifyHandle(realFraction);
        System.out.println(egyptFraction);
    }

    private static String getEgyptFractionWithSpecifyHandle(String realFraction){
        /*split to integer*/
        String[] strings = realFraction.split("/");
        /*numerator and denominator*/
        int numerator = Integer.parseInt(strings[0]);
        int denominator = Integer.parseInt(strings[1]);
        /**/
        StringBuilder egyptFraction = new StringBuilder();
        /**
         * a/b = 1/c + x/y
         * c = b/a + 1;
         * x is the new a, x = a*c - b
         * y is the new b, y = b*c;
         */
        while((numerator > 1) && (denominator%numerator != 0)){/*keep loop*/
            int c = denominator/numerator + 1;
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(c);/*this Egypt fraction*/
            egyptFraction.append("+");/*plus next one*/
            /*update numerator and denominator*/
            numerator = numerator * c - denominator;
            denominator = denominator * c;

            if(numerator ==3 && (denominator % 2 == 0)) break;
        }


        if(denominator%numerator == 0){/*change to real fraction and add this one*/
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(denominator/numerator);
        }
        else if(numerator == 3){/*numerator == 3, i do not know why, but huawei oj need*/
            /*add last one*/
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(denominator/2);
            egyptFraction.append("+");

            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(denominator);
            }
        return egyptFraction.toString();
    }

    private static String getEgyptFractionWithBruteForce(String realFraction){
        /*split to integer*/
        String[] strings = realFraction.split("/");
        /*numerator and denominator*/
        int numerator = Integer.parseInt(strings[0]);
        int denominator = Integer.parseInt(strings[1]);
        /**
         * it would just brute force to loop, and found the result
         * a/b - 1/c > 0, found the first c, c start from 2
         * then update a and b
         */
        StringBuilder egyptFraction = new StringBuilder();
        while((numerator > 1) && (denominator%numerator != 0)){/*keep loop*/
            int c = denominator/numerator;
            for(int i = 2; i < denominator; i++){
                /**
                 * it should be a/b - 1/i > 0, but it it float/double
                 * => (a*i-b)/b*i > 0, because b*i > 0 => just check a*i - b > 0
                 */
                if((numerator * i - denominator) > 0){
                    c = i;/*first c to make a/b - 1/c > 0*/
                    break;
                }
            }
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(c);/*this Egypt fraction*/
            egyptFraction.append("+");/*plus next one*/
            /*update numerator and denominator*/
            numerator = numerator * c - denominator;
            denominator = denominator * c;
        }

        /*numerator == 1*/
        if(numerator == 1){/*add last one*/
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(denominator);
        }
        else if(denominator%numerator == 0){/*change to real fraction and add this one*/
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(denominator/numerator);
        }
        return egyptFraction.toString();
    }
    /**
     *
     * @param realFraction
     * @return
     * this is a good algorithm, but it seems that huawei platform did not want this
     */
    private static String getEgyptFractionWithGreedy(String realFraction){
        /*split to integer*/
        String[] strings = realFraction.split("/");
        /*numerator and denominator*/
        int numerator = Integer.parseInt(strings[0]);
        int denominator = Integer.parseInt(strings[1]);
        /**/
        StringBuilder egyptFraction = new StringBuilder();
        /**
         * a/b = 1/c + x/y
         * c = b/a + 1;
         * x is the new a, x = a*c - b
         * y is the new b, y = b*c;
         */
        while((numerator > 1) && (denominator%numerator != 0)){/*keep loop*/
            int c = denominator/numerator + 1;
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(c);/*this Egypt fraction*/
            egyptFraction.append("+");/*plus next one*/
            /*update numerator and denominator*/
            numerator = numerator * c - denominator;
            denominator = denominator * c;
        }

        /*numerator == 1*/
        if(numerator == 1){/*add last one*/
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(denominator);
        }
        else if(denominator%numerator == 0){/*change to real fraction and add this one*/
            egyptFraction.append(1);
            egyptFraction.append("/");
            egyptFraction.append(denominator/numerator);
        }
        return egyptFraction.toString();
    }
}
