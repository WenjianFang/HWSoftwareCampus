/**
 * Created by Wenjian on 2016/12/19, 0019.
 */

import java.util.Scanner;

/**
 * Encrypt, English character: replace with the one behind it and change to UperCase/LowerCase;
 *          Digits: plus 1
 * Decrypt, Reverse action
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*As required, first one is to encrypt string, and next one is to decrypt*/
        String toEncryptString = sc.nextLine().toString();
        String toDecryptString = sc.nextLine().toString();

        String encryptString = encrypt(toEncryptString);/*encrypt*/
        String decryptString = decrypt(toDecryptString);/*decrypt*/

        System.out.println(encryptString);
        System.out.println(decryptString);
    }

    /**
     *
     * @param toEncryptString, string to be encrypt, String
     * @return string which is encrypt, String
     */
    private static String encrypt(String toEncryptString){
        char[] encrytString = new char[toEncryptString.length()];
        for(int i = 0; i < toEncryptString.length(); i++){
            if((toEncryptString.charAt(i) >= 'a' && toEncryptString.charAt(i) <= 'z')){
                /*plus 1 is next character, minus ('a'-'A') is to UpCase*/
                if(toEncryptString.charAt(i) != 'z')
                    encrytString[i] = (char)((toEncryptString.charAt(i) + 1) - ('a' - 'A'));
                else
                    encrytString[i] = 'A';
            }
            else if((toEncryptString.charAt(i) >= 'A' && toEncryptString.charAt(i) <= 'Z')){
                /*plus 1 is next character, plus ('a'-'A') is to LowerCase*/
                if(toEncryptString.charAt(i) != 'Z')
                    encrytString[i] = (char)((toEncryptString.charAt(i) + 1) + ('a' - 'A'));
                else
                    encrytString[i] = 'a';
            }
            else if((toEncryptString.charAt(i) >= '0' && toEncryptString.charAt(i) <= '9')){
                /*plus 1 is next character*/
                if(toEncryptString.charAt(i) != '9')
                    encrytString[i] = (char)(toEncryptString.charAt(i) + 1);
                else
                    encrytString[i] = '0';
            }
            else{
                encrytString[i] = toEncryptString.charAt(i);
            }
        }
        return String.valueOf(encrytString);
    }

    /**
     *
     * @param toDecryptString, string to be decrypt, String
     * @return, string which is decrypted, String
     */
    private static String decrypt(String toDecryptString){
        char[] decrytString = new char[toDecryptString.length()];
        for(int i = 0; i < toDecryptString.length(); i++){
            if((toDecryptString.charAt(i) >= 'a' && toDecryptString.charAt(i) <= 'z')){
                /*minus 1 is next character, minus ('a'-'A') is to UpCase*/
                if(toDecryptString.charAt(i) != 'a')
                    decrytString[i] = (char)((toDecryptString.charAt(i) - 1) - ('a' - 'A'));
                else
                    decrytString[i] = 'Z';
            }
            else if((toDecryptString.charAt(i) >= 'A' && toDecryptString.charAt(i) <= 'Z')){
                /*minus 1 is next character, plus ('a'-'A') is to LowerCase*/
                if(toDecryptString.charAt(i) != 'A')
                    decrytString[i] = (char)((toDecryptString.charAt(i) - 1) + ('a' - 'A'));
                else
                    decrytString[i] = 'z';
            }
            else if((toDecryptString.charAt(i) >= '0' && toDecryptString.charAt(i) <= '9')){
                /*minus 1 is next character*/
                if(toDecryptString.charAt(i) != '0')
                    decrytString[i] = (char)(toDecryptString.charAt(i) - 1);
                else
                    decrytString[i] = '9';
            }
            else{
                decrytString[i] = toDecryptString.charAt(i);
            }
        }
        return String.valueOf(decrytString);
    }

}
