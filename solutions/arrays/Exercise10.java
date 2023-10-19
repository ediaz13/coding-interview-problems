package solutions.arrays;

public class Exercise10 {
    /*
    Given a non-empty array of integers arr, create a function that returns the index of a peak element.
    We consider an element as peak if it's greater than or equal to its neighbors, the next and previous element
    (assume that arr[-1] and arr[n] are equal to -∞). And if there are multiple peaks in arr, just return the index of one of them.

            Example 1:
            Input: arr = [4, 5, 8, 3]
            Output: 2

            Explanation: arr[2] is a peak element because it's greater than or equal to arr[1], and greater than or equal to arr[3]

            Example 2:
            Input: arr = [1, 3, 4, 7, 8]
            Output: 4

            Explanation: arr[4] is a peak element because it's greater than or equal to arr[3], which is it's only neighbor

            Example 3:
            Input: arr = [1, 5, 2, 6, 6, 3]
            Output: 3

        Explanation: arr[3] is a peak element because it's greater than or equal to arr[2] and greater than or equal to arr[4]
        (other valid outputs would be 1 and 4, because arr[1] and arr[4] are also peak elements)
     */
    public int findPeak(int[] arr){
        int peak = Integer.MIN_VALUE;
        for (int i= 0; i < arr.length; i++) {
            if ( (i == 0 || arr[i] <= arr[i-1]) &&
                    (i == arr.length || arr[i] <= arr[i+1])) {
                peak = i;
            }
        }

        return peak;
    }

    public int findPeakLog(int[] arr){
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            int mid = (left + right)/2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid +1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

    }
}
