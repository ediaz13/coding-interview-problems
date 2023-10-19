package solutions.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Exercise1 {
    /*
    Given an array of integers arr and an integer k, create a boolean function that checks if there exist two elements
     in arr such that we get k when we add them together.

    Example 1:
    Input: arr = [4, 5, 1, -3, 6], k = 11
    Output: true

    Explanation: 5 + 6 is equal to 11

    Example 2:
    Input: arr = [4, 5, 1, -3, 6], k = -2
    Output: true

    Explanation: 1 + (-3) is equal to -2

    Example 3:
    Input: arr = [4, 5, 1, -3, 6], k = 8
    Output: false

    Explanation: there is no pair that sums up to 8
     */


    public static boolean findPair(int[] arr, int k){
        boolean findPair = false;

        HashMap<Integer, Boolean> hashSetNumeros = new HashMap<Integer, Boolean>();

        for (int i = 0; i < arr.length; i++) {

            if (hashSetNumeros.containsKey(k - arr[i])) {
                return true;
            } else {
                hashSetNumeros.put(arr[i], true);
            }

        }

        return findPair;
    }

    public static void main(String[] args) {
        int k = 34;

        int[] arrayInt = {3, 4, 6, 7, 9, 2};

        System.out.println(findPair(arrayInt, k));
    }
}
