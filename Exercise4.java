import java.util.HashMap;

public class Exercise4 {

    /*
        Given an array of integers arr that contains n+1 elements between 1 and n inclusive, create a function that returns the duplicate element (the element that appears more than once). Assume that:
        - There is only one duplicate number
        - The duplicate number can be repeated more than once

        Example 1:
        Input: arr = [4, 2, 1, 3, 1]
        Output: 1

        Example 2:
        Input: arr = [1, 4, 2, 2, 5, 2]
        Output: 2

         */
    public int findDuplicate(int[] arr){
        // your code here
        int duplicateInt = 0;
        HashMap<Integer, Boolean> booleanHashMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < arr.length; i++) {
            if (booleanHashMap.containsKey(arr[i])) {
                return arr[i];
            } else {
                booleanHashMap.put(arr[i], true);
            }
        }

        return duplicateInt;
    }

    public static void main(String[] args) {
        int[] arrayInt = {3, 4, 6, 7, 9, 2, 6, 6};

    }
}
