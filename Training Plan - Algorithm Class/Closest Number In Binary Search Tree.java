/*
In a binary search tree, find the node containing the closest number to the given target number.

Assumptions:

The given root is not null.
There are no duplicate keys in the binary search tree.
Examples:

    5
  /    \
2      11
     /    \
    6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6

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
  public int closest(TreeNode root, int target) {
    if (root.key == target) return root.key;
    if (root.key < target) {
      if (root.right == null) {
        return root.key;
      } else {
        int rightClosest = closest(root.right, target);
        return target - root.key < Math.abs(rightClosest - target) ? root.key : rightClosest;
      }
    } else if (root.key > target) {
      if (root.left == null) {
        return root.key;
      } else {
        int leftClosest = closest(root.left, target);
        return root.key - target < Math.abs(leftClosest - target) ? root.key : leftClosest;
      }
    }
    return 0;
  }
}
