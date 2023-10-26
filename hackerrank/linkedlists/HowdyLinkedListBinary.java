package hackerrank.linkedlists;

public class HowdyLinkedListBinary {
    /*
     * Complete the 'getNumber' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_SINGLY_LINKED_LIST binary as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;

    }


    public static long getNumber(SinglyLinkedListNode binary) {
        // Write your code here
        long decimalNumber = 0;

        while(binary != null) {
            decimalNumber = decimalNumber << 1 + binary.data;
            binary = binary.next;
        }

        return decimalNumber;

    }
    public static void main(String[] args) {

    }
}
