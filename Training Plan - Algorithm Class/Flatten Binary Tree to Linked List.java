/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
  public TreeNode flatten(TreeNode root) {
    flattenTree(root);
    return root;
  }
  private void flattenTree(TreeNode root) {
    if (root == null || root.left == null && root.right == null) return;
    TreeNode right = root.right;
    flatten(root.left);
    flatten(right);
    root.right = root.left;
    root.left = null;
    TreeNode cur = root;
    while (cur.right != null) {
      cur = cur.right;
    }
    cur.right = right;
  }
}
