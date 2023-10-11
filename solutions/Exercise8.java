package solutions;

public class Exercise8 {

    /*
    Given a linked list of integers list, create a function that reverses
    it in-place without using an additional data structure.

    Example 1:
    Input: list = 5 -> 3 -> 6 -> 4 -> 7 -> null
    Output: 7 -> 4 -> 6 -> 3 -> 5 -> null

    Example 2:
    Input: list = 1 -> 2 -> 3 -> null
    Output: 3 -> 2 -> 1 -> null

     */
    static class Node{
        int data;
        Node next;
        Node(int data){this.data = data; this.next = null;}
        Node(int data, Node next){this.data = data; this.next = next;}
    }

    static class LinkedList{
        Node head;
        LinkedList(){this.head = null;}
        LinkedList(Node head){this.head = head;}
    }

    public void reverseList(LinkedList list){
        // your code here
        Node previous = null;
        Node current = list.head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        list.head = previous;

    }

    public static void main(String[] args) {

    }
}
