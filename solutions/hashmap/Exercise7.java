package solutions.hashmap;

import java.util.HashMap;

public class Exercise7 {

    /*
    Given a string str made of alphabetical letters only, create a function that returns the length of the longest substring without repeating characters.

    Example 1:
    Input: str = "abcdbeghef"
    Output: 6
    Explanation: the longest substring without repeating characters is "cdbegh", its length is 6

    Example 2:
    Input: str = "aaaaa"
    Output: 1
    Explanation: the longest substring without repeating characters is "a", its length is 1

    Example 3:
    Input: str = "eddy"
    Output: 2
    Explanation: the longest substring without repeating characters is "ed" (or "dy"), its length is 2
     */

    public static int longestSubstringWithoutRepeating(String str){
        // your code here
        int maxLength = 0;
        int start = 0;
        int numberOfAlphabetCharacters = 128;
        int[] indexes = new int[numberOfAlphabetCharacters];
        for(int i = 0; i < 128; i++) indexes[i] = -1;

        for(int i = 0; i < str.length(); i++){
            if(indexes[(int) str.charAt(i)] >= start) {
                start = indexes[(int) str.charAt(i)] + 1;
            }

            indexes[(int) str.charAt(i)] = i;
            maxLength = Math.max(maxLength, i-start+1);
        }

        return maxLength;
    }

    public static int pedorroLongestSubstringWithoutRepeating(String str){
        // your code here
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String subString = str.substring(i, j+1);

            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcdbeghef";

        System.out.println(longestSubstringWithoutRepeating(str));


    }

}
