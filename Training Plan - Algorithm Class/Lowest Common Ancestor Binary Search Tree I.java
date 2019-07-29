/*
Given two keys in a binary search tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary search tree

There are no duplicate keys in the binary search tree

The given two nodes are guaranteed to be in the binary search tree

Examples

        5
      /   \
     2     12
   /  \      \
  1    3      14

The lowest common ancestor of 1 and 14 is 5

The lowest common ancestor of 1 and 3 is 2
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
  public TreeNode lca(TreeNode root, int p, int q) {
    return lca(root, Integer.MAX_VALUE, Integer.MIN_VALUE, p, q);
  }
  private TreeNode lca(TreeNode root, int max, int min, int p, int q) {
    if (root == null || root.key == p || root.key == q) return root;
    TreeNode left = null;
    if ((p < root.key && p > min) || (q < root.key && q > min)) {
      left = lca(root.left, root.key, min, p, q);
    }
    TreeNode right = null;
    if ((p > root.key && p < max) || (q > root.key && q < max)) {
      right = lca(root.right, max, root.key, p, q);
    }
    if (left == null && right == null) {
      return null;
    } else if (left == null || right == null) {
      return left == null ? right : left;
    } else {
      return root;
    }
  }
}
