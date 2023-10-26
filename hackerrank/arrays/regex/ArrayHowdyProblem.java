package hackerrank.arrays.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayHowdyProblem {

    /*
     * Complete the 'maxTickets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY tickets as parameter.
     */

    public static int maxTickets(List<Integer> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            return 0;
        }

        Collections.sort(tickets);

        int maxLenght = 1;
        int currentLenght = 1;

        for (int i = 1; i < tickets.size(); i++) {
            if (Math.abs(tickets.get(i) - tickets.get(i - 1)) <= 1) {
                currentLenght++;
            } else {
                currentLenght = 1;
            }

            maxLenght = Math.max(maxLenght, currentLenght);
        }

        return maxLenght;
    }
    public static void main(String[] args) {


        List<Integer> tickets = new ArrayList<>();
        tickets.add(8);
        tickets.add(5);
        tickets.add(4);
        tickets.add(8);
        tickets.add(4);

        int result = ArrayHowdyProblem.maxTickets(tickets);
        System.out.println(result);
    }
}
