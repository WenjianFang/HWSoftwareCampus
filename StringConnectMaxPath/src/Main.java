/**
 * Created by Wenjian on 2017/2/28, 0028.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given n strings, this string's last m characters is the next string's first m characters
 * output the maximum connected string
 * ABCC ABCD BCCE BCDE CCEF BCCE CCEG CEGF-> ABCCEGF
 * m = 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String[] stringArray = inputString.split(" ");

        String connectedPath = getMaxConnectPath(stringArray);
        System.out.println(connectedPath);
    }

    private static String getMaxConnectPath(String[] stringArray) {
        List<List<String>> allPath = new ArrayList<>();
        for(int i = 0; i < stringArray.length; i++) {
            List<String> onePath = new ArrayList<>();
            onePath.add(stringArray[i]);
            getOnePath(stringArray, i + 1, stringArray[i].substring(1), allPath, onePath);
        }
        /*max length*/
        int maxLength = 0;
        int maxIndex = -1;
        for(int i = 0; i < allPath.size(); i++) {
            if(allPath.get(i).size() > maxLength) {
                maxLength = allPath.get(i).size();
                maxIndex = i;
            }
        }
        StringBuilder connectedPath = new StringBuilder();
        if(maxIndex != -1) {
            for(int i = 0; i < allPath.get(maxIndex).size(); i++) {
                connectedPath.append(allPath.get(maxIndex).get(i));
            }
        }
        return connectedPath.toString();
    }

    private static void getOnePath(String[] stringArray, int start, String match, List<List<String>> allPath, List<String> onePath) {
        if(start == stringArray.length) {
            List<String> tmpPath = new ArrayList<>();
            tmpPath.addAll(onePath);
            allPath.add(tmpPath);

            onePath.remove(onePath.size() - 1);
            return;
        }
        for(int i = start; i < stringArray.length; i++) {
            if(stringArray[i].substring(0,3).equals(match)) {
                onePath.add(stringArray[i].substring(3));
                getOnePath(stringArray, i + 1, stringArray[i].substring(1), allPath, onePath);
            }
        }
        List<String> tmpPath = new ArrayList<>();
        tmpPath.addAll(onePath);
        allPath.add(tmpPath);

        onePath.remove(onePath.size() - 1);
        return;
    }
}
