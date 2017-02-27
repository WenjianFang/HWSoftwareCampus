/**
 * Created by Wenjian on 2017/2/27, 0027.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * key value  =>
 * 0, 1            0, 3
 * 0, 2
 * 1, 2            1, 2
 * 3, 4            3, 4
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pairNum = sc.nextInt();

        Map<Integer, Integer> record = new HashMap<>();
        int key = 0;
        int value = 0;
        for(int i = 0; i < pairNum; i++) {
            key = sc.nextInt();
            value = sc.nextInt();
            if(record.containsKey(key)) {
                value += record.get(key);
                record.put(key, value);
            }
            else {
                record.put(key, value);
            }
        }

        /*print, key and value in two line output*/
        for(Map.Entry<Integer, Integer> entry : record.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
