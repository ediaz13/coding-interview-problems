package solutions.linkedlists;

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

    public static Node reverseNodes(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node reversed = reverseNodes(node.next);
        node.next.next = node;
        node.next = null;

        return reversed;
    }

    public static void reverseListRecursive(LinkedList list){
        //Time Complexity O(n)
        //Space Complexity O(n)
        list.head = reverseNodes(list.head);
    }

    public static void reverseList(LinkedList list){
        // I'll change the method using pointers!
        //Time Complexity O(n)
        //Space Complexity O(1)

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


    public static void reverseListShady(LinkedList list){
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
            for (int j = 0; j < length - i - 1; j++) {
                right = right.next;
            }

            temp = new Node(0);
            temp.data = left.data;
            left.data = right.data;
            right.data = temp.data;

            left = left.next;
        }

    }

    public static void main(String[] args) {
        Node node_1 = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(4);
        Node node_5 = new Node(5);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        LinkedList linkedList = new LinkedList(node_1);

        //reverseListShady(linkedList);
        //reverseList(linkedList);
        reverseListRecursive(linkedList);

        while (linkedList.head != null) {
            System.out.print(linkedList.head.data);
            linkedList.head = linkedList.head.next;
        }
    }
}
