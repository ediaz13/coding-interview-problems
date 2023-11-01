package solutions.binaryTree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exercise14 {
    /*
    Given a binary tree root, create a function that prints its nodes in level order (level by level).

    Example 1:
    Input: root = [5, 10, 3, 4, 6, null, 7, null, 8, 9, 1, 2]
    Output: 5 10 3 4 6 7 8 9 1 2

     */

    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public static void bfs(Tree root){
        // your code here
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree poppedNode = queue.remove();

            if (poppedNode == null) {
                continue;
            } else {
                System.out.println(poppedNode.data);
                queue.add(poppedNode.left);
                queue.add(poppedNode.right);
            }
        }

    }

    public static void bfsRec(Tree root, int i, Queue<Tree> queue){
        if (i >= queue.size()) {
            return;
        } else {
            Tree poppedNode = queue.remove();
            if (poppedNode != null) {
                System.out.println(poppedNode.data);
                queue.add(poppedNode.left);
                queue.add(poppedNode.right);

            }

            bfsRec(root, i + 1, queue);
        }
    }

    public static void bfsNice(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        bfsRec(root, 0, queue);
    }

    public static void main(String[] args) {
        //Create a Tree.
        Tree root = new Tree(1,
                new Tree(2, new Tree(4), new Tree(5)),
                new Tree(3)
        );
        
        Exercise14.bfsNice(root);


    }
}
