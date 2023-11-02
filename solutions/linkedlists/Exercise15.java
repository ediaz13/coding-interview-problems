package solutions.linkedlists;

public class Exercise15 {
    /*
    Given a linked list of integers list, create a function that sorts it.
    Note that the function returns nothing, the linked list must be sorted in-place.

    Example 1:
    Input: list = 4 -> 8 -> 1 -> 6 -> 2 -> 5 -> null
    Output: 1 -> 2 -> 4 -> 5 -> 6 -> 8 -> null
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

    public static void sortList(LinkedList list){
        // BubbleSort
        //O(n^2)
        //O(1)
        Node headNode = list.head;

        while (headNode != null) {
            Node currentNode = list.head;
            while (currentNode.next != null) {
                if (currentNode.data > currentNode.next.data) {
                    int temp = currentNode.data;
                    currentNode.data = currentNode.next.data;
                    currentNode.next.data = temp;
                }
                currentNode = currentNode.next;

            }
            headNode = headNode.next;
        }

    }

    public static Node mergeSort(Node head) {
        //Mergesort
        //O(nlogn)
        //O(logn)

        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node headRightHalf = slow.next;
        slow.next = null;

        head = mergeSort(head);
        headRightHalf = mergeSort(headRightHalf);

        return mergeSortedLists(head, headRightHalf);
    }

    private static Node mergeSortedLists(Node headLeft, Node headRight) {
        Node ptrLeft = headLeft;
        Node ptrRight = headRight;
        Node returnedHead = null;
        Node tail = null;

        while (ptrLeft != null || ptrRight != null) {
            Node lower;
            if (ptrLeft != null && ptrRight != null) {
                if (ptrLeft.data < ptrRight.data) {
                    lower = ptrLeft;
                    ptrLeft = ptrLeft.next;
                } else {
                    lower = ptrRight;
                    ptrRight = ptrRight.next;
                }
            } else if (ptrLeft != null) {
                lower = ptrLeft;
                ptrLeft = ptrLeft.next;
            } else {
                lower = ptrRight;
                ptrRight = ptrRight.next;
            }

            if (returnedHead == null) {
                returnedHead = lower;
                tail = lower;
            } else {
                tail.next = lower;
                tail = tail.next;
            }
        }


        return returnedHead;
    }

    public static void main(String[] args) {
        Node node_1 = new Node(5);
        Node node_2 = new Node(4);
        Node node_3 = new Node(3);
        Node node_4 = new Node(2);
        Node node_5 = new Node(1);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        LinkedList linkedList = new LinkedList(node_1);


        /*
        while (linkedList.head != null) {
            System.out.println(linkedList.head.data);
            linkedList.head = linkedList.head.next;
        }
         */


        sortList(linkedList);
        mergeSort(node_5);

        while (linkedList.head != null) {
            System.out.println(linkedList.head.data);
            linkedList.head = linkedList.head.next;
        }

    }
}
