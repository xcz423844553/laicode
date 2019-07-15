/*
Check if a given binary tree is symmetric.

Examples

        5
      /    \
    3        3
  /   \    /   \
1      4  4      1

is symmetric.

        5
      /    \
    3        3
  /   \    /   \
1      4  1      4

is not symmetric.

Corner Cases

What if the binary tree is null? Return true in this case.
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
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSame(root.left, root.right);
  }
  public boolean isSame(TreeNode one, TreeNode two) {
    if (one == null || two == null) return one == null && two == null;
    if (one.key != two.key) return false;
    return isSame(one.left, two.right) && isSame(one.right, two.left);
  }
}
