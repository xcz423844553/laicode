/*
Given a binary tree in which each node contains an integer number. Find the maximum possible path sum from a leaf to root.

Assumptions

The root of given binary tree is not null.

Examples

         10
       /    \
    -2       7
  /    \
8      -4

The maximum path sum is 10 + 7 = 17.
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
  public int maxPathSumLeafToRoot(TreeNode root) {
    if (root == null) return 0;
    int leftSum = maxPathSumLeafToRoot(root.left);
    int rightSum = maxPathSumLeafToRoot(root.right);
    if (root.left == null) return rightSum + root.key;
    if (root.right == null) return leftSum + root.key;
    return Math.max(leftSum + root.key, rightSum + root.key);
  }
}
