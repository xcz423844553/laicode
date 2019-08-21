/*
Given a binary tree in which each node contains an integer number. The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.

If there does not exist any such paths, return 0.

Examples

    5
  /    \
2      11
     /    \
    6     14

The diameter of this tree is 4 (2 → 5 → 11 → 14)

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
  public int diameter(TreeNode root) {
    int[] max = new int[1];
    diameter(root, max);
    return max[0];
  }
  private int diameter(TreeNode root, int[] max) {
    if (root == null) return 0;
    int leftD = diameter(root.left, max);
    int rightD = diameter(root.right, max);
    if (root.left == null || root.right == null) return root.left == null ? rightD + 1 : leftD + 1;
    max[0] = Math.max(max[0], leftD + rightD + 1);
    return Math.max(leftD, rightD) + 1;
  }
}
