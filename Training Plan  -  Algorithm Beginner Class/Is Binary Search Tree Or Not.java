/*
Determine if a given binary tree is binary search tree.There should no be duplicate keys in binary search tree.

Assumptions

You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.

Corner Cases

What if the binary tree is null? Return true in this case.
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
  public boolean isBST(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private boolean isBST(TreeNode root, int min, int max) {
    if (root == null) return true;
    if (root.key <= min || root.key >= max) return false;
    return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
  }
}
