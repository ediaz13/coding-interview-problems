package solutions.hashmap;

import java.util.HashMap;

public class Exercise2 {
    /*
    Given a string str, create a function that returns the first repeating character.
    If such character doesn't exist, return the null character '\0'.

    Example 1:
    Input: str = "inside code"
    Output: 'i'

    Example 2:
    Input: str = "programming"
    Output: 'r'

    Example 3:
    Input: str = "abcd"
    Output: '\0'

    Example 4:
    Input: str = "abba"
    Output: 'b'
     */

    public static char firstRepeatingCharacter(String str){
        HashMap<Character, Boolean> booleanHashMap = new HashMap<Character, Boolean>();

        char[] strArr = str.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            if (booleanHashMap.containsKey(strArr[i])) {
                return strArr[i];
            } else {
                booleanHashMap.put(strArr[i], true);
            }
        }
        return '\0';
    }
    public static void main(String[] args) {

    }
}
