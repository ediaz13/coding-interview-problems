package solutions.arrays;

public class Exercise13 {
    /*
    Given two strings str1 and str2, create a function that returns the first index where we can find str2 in str1. If we cannot find str2 in str1, the function must return -1.
    Try to solve the problem without using the built-in .indexOf() method.

    Example 1:
    Input: str1 = "inside", str2 = "side"
    Output: 2
    Explanation: we can find "side" in "inside" by starting from the index 2

    Example 2:
    Input: str1 = "inside", str2 = "in"
    Output: 0
    Explanation: we can find "in" in "inside" by starting from the index 0

    Example 3:
    Input: str1 = "inside", str2 = "code"
    Output: -1

    Explanation: we can't find "code" in "inside"
     */

    public static int substrIndex(String str1, String str2){
        // your code here
        int lengthStr1 = str1.length();
        int lengthStr2 = str1.length();

        for (int i = 0; i < lengthStr1 - lengthStr2 +1; i++) {
            boolean found = true;
            for (int j = 0; j < lengthStr2; j++) {
                if (str1.charAt(i+j) != str2.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;
            }
        }

        return -1;
    }

    public static int findSubstringIndex(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if (m > n) {
            // If str2 is longer than str1, it can't be a substring.
            return -1;
        }

        for (int i = 0; i <= n - m; i++) {
            // Check if the substring of str1 starting at index i is equal to str2.
            if (str1.substring(i, i + m).equals(str2)) {
                return i;
            }
        }

        // If no match is found, return -1.
        return -1;
    }

    public static int findSubstringIndexPro(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (m == 0) return 0; // Empty substring is always present.

        int[] lps = computeLPSArray(str2);

        int i = 0; // Pointer for str1
        int j = 0; // Pointer for str2

        while (i < n) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                // Found a match
                return i - j;
            } else if (i < n && str1.charAt(i) != str2.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Update j using the LPS array
                } else {
                    i++; // No characters in str2 can be a prefix
                }
            }
        }

        return -1; // No match found
    }

    private static int[] computeLPSArray(String str) {
        int m = str.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }




    public static void main(String[] args) {
        String str1 = "inside";
        String str2 = "side";

        System.out.println(findSubstringIndex(str1, str2));
    }

}
