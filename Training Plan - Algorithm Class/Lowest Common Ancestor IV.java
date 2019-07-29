/*
Given K nodes in a binary tree, find their lowest common ancestor.

Assumptions

K >= 2

There is no parent pointer for the nodes in the binary tree

The given K nodes are guaranteed to be in the binary tree

Examples

        5
      /   \
     9     12
   /  \      \
  2    3      14

The lowest common ancestor of 2, 3, 14 is 5

The lowest common ancestor of 2, 3, 9 is 9
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
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    Set<TreeNode> set = new HashSet<>();
    for (TreeNode n : nodes) {
      set.add(n);
    }
    return lowestCommonAncestor(root, set);
  }
  private TreeNode lowestCommonAncestor(TreeNode root, Set<TreeNode> nodes) {
    if (root == null) return null;
    if (nodes.contains(root)) return root;
    TreeNode left = lowestCommonAncestor(root.left, nodes);
    TreeNode right = lowestCommonAncestor(root.right, nodes);
    if (left == null && right == null) {
      return null;
    } else if (left == null || right == null) {
      return left == null ? right : left;
    } else {
      return root;
    }
  }
}
