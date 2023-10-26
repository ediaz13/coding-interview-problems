package hackerrank.arrays.regex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayHowdySecondProblem {
    /*
     * Complete the 'minDiff' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minDiff(List<Integer> arr) {
        // Write your code here
        int minDiff = 0;

        Collections.sort(arr);

        if (arr == null || arr.isEmpty()) {
            return 0;
        }

        for (int i = 1; i < arr.size(); i++) {
            minDiff += Math.abs(arr.get(i) - arr.get(i - 1));
        }
        
        return minDiff;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(1);

        System.out.println(minDiff(list));

    }
}
