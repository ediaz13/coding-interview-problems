package solutions.binaryTree;

public class Exercise5 {
    /*
        Given a binary tree of integers root, create 3 functions to print the tree nodes in preorder, inorder, and postorder traversal.
        Preorder: print the root value, then print the left subtree, then print the right subtree.
        Inorder: print the left subtree, then print the root value, then print the right subtree.
        Postorder: print the left subtree, then print the right subtree, then print the root value.

        Example 1:

        Input: root = [1, 2, 3, 4, 5, 6, 7]

        Output:
        Preorder: 1 2 4 5 3 6 7
        Inorder: 4 2 5 1 6 3 7
        Postorder: 4 5 2 6 7 3 1

                                 1
                               /    \
                              2      3
                            /  \    /  \
                           4    5  6    7

        Example 2:

        Input: root = [6, 8, 13, 2, 1, 5, null, 7]

        Output:
        Preorder: 6 8 2 7 1 13 5
        Inorder: 7 2 8 1 6 5 13
        Postorder: 7 2 1 8 5 13 6

                                  6
                               /    \
                              8      13
                            /  \    /
                           2    1  5
                          /
                         7
     */
    static class Tree {
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public static void dfsPreorder(Tree root){
        // your code here
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        dfsPreorder(root.left);
        dfsPreorder(root.right);
    }

    public static void dfsInorder(Tree root){
        // your code here
        if (root == null) {
            return;
        }

        dfsInorder(root.left);
        System.out.println(root.data);
        dfsInorder(root.right);
    }

    public static void dfsPostorder(Tree root){
        // your code here
        if (root == null) {
            return;
        }

        dfsPostorder(root.left);
        dfsPostorder(root.right);
        System.out.println(root.data);

    }

    public static void main(String[] args) {
        //EL MAIN PAI
        /// Create a sample binary tree
        Tree root = new Tree(1,
                new Exercise5.Tree(2, new Exercise5.Tree(4), new Exercise5.Tree(5)),
                new Exercise5.Tree(3)
        );

        Exercise5.dfsPreorder(root);
        //solutions.binaryTree.Exercise6.Exercise5.dfsInorder(root);
        //solutions.binaryTree.Exercise6.Exercise5.dfsPostorder(root);


    }
}