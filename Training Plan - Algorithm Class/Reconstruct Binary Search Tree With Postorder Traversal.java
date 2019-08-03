/*
Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree

Examples

postorder traversal = {1, 4, 3, 11, 8, 5}

the corresponding binary search tree is

        5
      /    \
    3        8
  /   \        \
1      4        11

How is the binary tree represented?

We use the pre order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:

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
  public TreeNode reconstruct(int[] post) {
    return reconstruct(post, 0, post.length - 1);
  }
  private TreeNode reconstruct(int[] post, int left, int right) {
    if (left > right) return null;
    TreeNode root = new TreeNode(post[right--]);
    int countRight = right;
    while (countRight >= left && post[countRight] > root.key) {
      countRight--;
    }
    root.left = reconstruct(post, left, countRight);
    root.right = reconstruct(post, countRight + 1, right);
    return root;
  }
}
