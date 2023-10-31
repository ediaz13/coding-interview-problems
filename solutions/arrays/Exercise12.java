package solutions.arrays;

public class Exercise12 {
    /*
    Given a string str made of alphabetical letters only, create a function that returns the length of the longest palindrome string that can be made from letters of str
    Example 1:
    Input: str = "abbaba"
    Output: 5
    Explanation: one of the longest palindromes that can be made is "baaab", its length is 5

    Example 2:
    Input: str = "abbaaa"
    Output: 6
    Explanation: one of the longest palindromes that can be made is "baaaab", its length is 6

    Example 3:
    Input: str = "abbabab"
    Output: 7
    Explanation: one of the longest palindromes that can be made is "bbaaabb", its length is 7

    Example 4:
    Input: str = "abdccdceeebebc"
    Output: 13
    Explanation: one of the longest palindromes that can be made is "eedccbabccdee", its length is 13
     */

    public static int longestPalindrome(String str){
        // your code here
        int character[] = new int[128];
        int largestPalyndrome = 0;
        for (int i = 0; i < str.length(); i++ ){
            char wordChar = str.charAt(i);
            int asciiValChar = (int) wordChar;
            character[asciiValChar]++;
        }

        for (int integer : character) {
            if (integer % 2 == 0) {
                largestPalyndrome = largestPalyndrome + integer;
            } else {
                largestPalyndrome = largestPalyndrome + integer - 1;
            }
        }

        if (largestPalyndrome < str.length()) {
            largestPalyndrome++;
        }

        return largestPalyndrome;
    }

    public static void main(String[] args) {
        String str = "abbba";

        System.out.println(longestPalindrome(str));
    }
}
