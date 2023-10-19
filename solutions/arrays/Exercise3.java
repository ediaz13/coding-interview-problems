package solutions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Exercise3 {
    /*
    Given an array of integers arr, create a function that returns an array
    containing the values of arr without duplicates (the order doesn't matter).

    Example 1:
    Input: arr = [4, 2, 5, 3, 3, 1, 2, 4, 1, 5, 5, 5, 3, 1]
    Output: [4, 2, 5, 3, 1]

    Example 2:
    Input: arr = [1, 1, 1, 1, 1, 1, 1, 1]
    Output: [1]

    Example 3:
    Input: arr = [4, 4, 2, 3, 2, 2, 4, 3]
    Output: [4, 2, 3]
     */


    public static int[] removeDuplicates(int[] arr) {
        //O(N)
        //Space
        ArrayList<Integer> arrayListInt = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (!arrayListInt.contains(arr[i])) {
                arrayListInt.add(arr[i]);
            }
        }

        int[] newArr = new int[arrayListInt.size()];

        for (int i = 0; i < arrayListInt.size(); i++) {
            newArr[i] = arrayListInt.get(i);
        }

        return newArr;
    }

    public static void main(String[] args) {

        int[] arrayInt = {3, 4, 6, 7, 9, 2, 6, 6, 3, 3, 9};

        int[] arrayNew = removeDuplicates(arrayInt);

        for (int i = 0; i < arrayNew.length; i++) {
            System.out.println(arrayNew[i]);
        }

    }
}
