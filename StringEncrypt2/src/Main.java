/**
 * Created by Wenjian on 2016/12/21, 0021.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Give a key word, use this word's character to replace the a->z, no repeat
 * fill with remaining characters, by order
 *
 * Use Map to store the map relationship, <key, value>:key, original; value, encrypt
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String key = sc.nextLine().toString(); /*work key*/
        String toEncryptString = sc.nextLine().toString(); /*the string to be encrypted*/

        String encryptString = encrypt(key, toEncryptString);

        System.out.println(encryptString);
    }

    /**
     *
     * @param key, the word to replace a->z
     * @param toEncryptString, to be encrypted
     * @return encrypted string
     */
    private static String encrypt(String key, String toEncryptString){
        Map<Character, Character> code = getCode(key);

        char[] encryptString = new char[toEncryptString.length()];

        for(int i = 0; i < toEncryptString.length(); i++){
            /*a->z or A->Z*/
            if(((toEncryptString.charAt(i) >= 'a' && toEncryptString.charAt(i) <= 'z'))
                    ||((toEncryptString.charAt(i) >= 'A' && toEncryptString.charAt(i) <= 'Z'))){
                encryptString[i] = code.get(toEncryptString.charAt(i));/*get from code book*/
            }
            /*else do nothing*/
            else encryptString[i] = toEncryptString.charAt(i);
        }
        return String.valueOf(encryptString);
    }

    /**
     * get code book, as a mapping relationship
     * @param key, key word to replace original character
     * @return, code book , a map
     */
    private static Map getCode(String key){
        Map<Character, Character> code = new HashMap<>(); /*mapping from original character to code character*/
        key = key.toLowerCase(); /*for lower case*/

        char originalCh = 'a';
        int lowerToUp = 'a'-'A';
        for(int i = 0; i < key.length(); i++){
            if(!code.containsValue(key.charAt(i))){/*this character can replace original character*/
                code.put(originalCh, key.charAt(i));
                code.put((char)(originalCh - lowerToUp), (char)(key.charAt(i) - lowerToUp));
                originalCh++;
            }
            /*else{}//repeat, do nothing*/
        }
        /*now from originalCh, should be fill with remaining characters by order*/
        for(char i = 'a'; i <= 'z'; i++){
            if(!code.containsValue(i)){/*this character can replace original character*/
                code.put(originalCh, i);
                code.put((char)(originalCh - lowerToUp), (char)(i - lowerToUp));
                originalCh++;
            }
            /*else{}//repeat, do nothing*/
        }
        return code;
    }
}
