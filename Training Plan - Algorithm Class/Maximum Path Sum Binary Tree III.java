/*
Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).

Assumptions

The root of given binary tree is not null

Examples

   -5
  /    \
2      11
     /    \
    6     14
           /
        -3

The maximum path sum is 11 + 14 = 25

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1
  /   \
 2     3
      /
    4
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
  public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    maxPathSum(root, 0, max);
    return max[0];
  }
  private void maxPathSum(TreeNode root, int preSum, int[] max) {
    if (root == null) return;
    int sum = root.key;
    if (preSum > 0) {
      sum += preSum;
    }
    max[0] = Math.max(max[0], sum);
    maxPathSum(root.left, sum, max);
    maxPathSum(root.right, sum, max);
  }
}
