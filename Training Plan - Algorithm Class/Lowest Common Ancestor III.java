/*
Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

Return null If any of the nodes is not in the tree.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5
      /   \
     9     12
   /  \      \
  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
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
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    Set<TreeNode> found = new HashSet<>();
    TreeNode ans = lca(root, one, two, found);
    return found.contains(one) && found.contains(two) ? ans : null;
  }
  private TreeNode lca(TreeNode root, TreeNode one, TreeNode two, Set<TreeNode> found) {
    if (root == null) return root;
    TreeNode left = lca(root.left, one, two, found);
    TreeNode right = lca(root.right, one, two, found);
    if (root.key == one.key || root.key == two.key) {
      found.add(root.key == one.key ? one : two);
      return root;
    } else if (left != null && right != null) {
      return root;
    } else if (left != null || right != null) {
      return left == null ? right : left;
    } else {
      return null;
    }
  }
}
