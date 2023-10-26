package solutions.linkedlists;

public class Exercise11 {

    /*
    Given a linked list of integers list, create a boolean function that checks if it's a palindrome linked list in constant space complexity.

    Example 1:
    Input: list = 1 -> 4 -> 6 -> 5 -> 6 -> 4 -> 1 -> null
    Output: true

    Example 2:
    Input: list = 8 -> 3 -> 1 -> 8 -> null
    Output: false

    Example 3:
    Input: list = 6 -> null
    Output: true

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

    public static boolean isPalindromeList(LinkedList list){
        // your code here
        //Time Complexity O(n^2)
        //Space Complexity O(1)

        int length = 0;
        Node temp = list.head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        Node left = list.head;

        for (int i = 0; i < length/2; i++) {
            Node right = list.head;
            for (int j = 0; j < length - i -1; j++) {
                right = right.next;
            }
            if (right.data != left.data) return false;

            left = left.next;
        }

        return true;
    }

    public static boolean isPalindromeListBetter(LinkedList list){
        // I'll change the method using pointers!
        //Time Complexity O(n)
        //Space Complexity O(1)

        Node slow = list.head;
        Node fast = list.head;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        Node head = list.head;

        while (slow != null) {
            if (slow.data != head.data) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static Node reverseList(Node node){
        Node previous = null;
        Node current = node;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;

    }


    public static void main(String[] args) {
        Node node_1 = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(5);
        Node node_5 = new Node(1);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        LinkedList linkedList = new LinkedList(node_1);

        System.out.println(isPalindromeList(linkedList));
        System.out.println(isPalindromeListBetter(linkedList));

    }
}
