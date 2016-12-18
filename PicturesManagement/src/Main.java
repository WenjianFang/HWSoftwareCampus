/**
 * Created by Wenjian on 2016/12/18, 0018.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given some pictures, named by characters
 * Sort these pictures by ASCII, ascend
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] pictures = sc.nextLine().toCharArray();/*input to be char array*/
        Arrays.sort(pictures);/*sort the pictures*/

        if(pictures.length > 0) {/*have pictures*/
            for (int i = 0; i < pictures.length; i++) {
//                if ((pictures[i] < '0') || (pictures[i] > 'z')) {/*pictures' name illegal*/
//                    System.out.println("Pictures name ERROR");
//                    return;
//                } else {
//                    System.out.print(pictures[i]);
//                }
                System.out.print(pictures[i]);
            }
        }
        else{
//            System.out.println("No pictures");
            return;
        }
    }
}
