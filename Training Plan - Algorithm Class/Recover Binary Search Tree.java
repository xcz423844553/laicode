/*
Given a Binary Search Tree with only two nodes swapped. Try to find them and recover the binary search tree.

Input: 

               4
              /  \
             2    6  
            / \  / \
           1  5  3  7

Output:        4
             /   \
            2     6
           / \   / \
          1   3 5   7
*/

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  private TreeNode prev;
  private TreeNode first;
  private TreeNode firstNext;
  private TreeNode second;
  public TreeNode recover(TreeNode root) {
    if (root == null) return root;
    recoverTraversal(root);
    if (second == null) {
      second = firstNext;
    }
    int k = first.key;
    first.key = second.key;
    second.key = k;
    return root;
  }
  public void recoverTraversal(TreeNode root) {
    if (root == null) return;
    recoverTraversal(root.left);
    if (prev != null && root.key < prev.key) {
      if (first == null) {
        first = prev;
        firstNext = root;
      } else {
        second = root;
      }
    }
    prev = root;
    recoverTraversal(root.right);
  }
}
