package solutions.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {

    /*
    Solve the problem [Java]
    Given a binary tree of integers root, create a function that reverses it left to right in-place.

    Example 1:

    Input: root = [1, 2, 3, 4, 5, 6, 7]

    Output: [1, 3, 2, 7, 6, 5, 4]

    Explanation:
                           1                                   1
                         /    \                              /    \
                        2      3                            3      2
                      /  \    /  \                        /  \    /  \
                     4    5  6    7                      7    6  5    4



    Example 2:

    Input: root = [6, 8, 13, 2, 1, 5, null, 7]

    Output: [6, 13, 8, null, 5, 1, 2, null, null, null, null, null, 7]

    Explanation:


     */

    public static ArrayList<Integer> tree = new ArrayList<>();

    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public static void reverseTree(Tree root){
        if (root == null) {
            return;
        }

        tree.add(root.data);

        Tree aux = root.left;
        root.left = root.right;
        root.right = aux;

        reverseTree(root.left);
        reverseTree(root.right);

    }

    public static void convertTreeToArrayList(Tree node, List<Integer> arrayList) {
        if (node == null)
            return;

        // Traverse left subtree
        convertTreeToArrayList(node.left, arrayList);

        // Add the value of the current node to the ArrayList
        arrayList.add(node.data);

        // Traverse right subtree
        convertTreeToArrayList(node.right, arrayList);
    }


    public static void main(String[] args) {
        //EL MAIN PAI
        /// Create a sample binary tree
        Tree root = new Exercise6.Tree(1,
                new Exercise6.Tree(2, new Exercise6.Tree(4), new Exercise6.Tree(5)),
                new Exercise6.Tree(3)
        );

        /*
                                       1
                                      / \
                                     2   3
                                    / \
                                   4   5

         */

        List<Integer> arrayList = new ArrayList<>();
        convertTreeToArrayList(root, arrayList);

        System.out.println("ArrayList: " + arrayList);

        Exercise6.reverseTree(root);
        System.out.println(tree);

        /*
                                       1
                                      / \
                                     3   2
                                        / \
                                       5   4

         */
    }
}
