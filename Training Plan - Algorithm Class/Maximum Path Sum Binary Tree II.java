/*
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 

Assumptions

The root of the given binary tree is not null

Examples

   -1
  /    \
2      11
     /    \
    6    -14

one example of paths could be -14 -> 11 -> -1 -> 2

another example could be the node 11 itself

The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

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
    int[] max = new int[]{Integer.MIN_VALUE};
    maxPathSum(root, max);
    return max[0];
  }
  private int maxPathSum(TreeNode root, int[] max) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
      max[0] = Math.max(max[0], root.key);
      return root.key;
    }
    int leftSum = maxPathSum(root.left, max);
    int rightSum = maxPathSum(root.right, max);
    if (leftSum <= 0) leftSum = 0;
    if (rightSum <= 0) rightSum = 0;
    int path = root.key + leftSum + rightSum;
    max[0] = Math.max(max[0], path);
    return Math.max(root.key + leftSum, root.key + rightSum);
  } 
}
