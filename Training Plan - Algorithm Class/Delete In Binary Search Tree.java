/*
Delete the target key K in the given binary search tree if the binary search tree contains K. Return the root of the binary search tree.

Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property should be maintained.

Assumptions

There are no duplicate keys in the binary search tree

The smallest larger node is first candidate after deletion
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
  public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) return root;
    if (root.key > key) {
      root.left = deleteTree(root.left, key);
    } else if (root.key < key) {
      root.right = deleteTree(root.right, key);
    } else {
      if (root.right == null) {
        return root.left;
      } else if (root.left == null) {
        return root.right;
      } else {
        TreeNode smallest = root.right;
        while (smallest.left != null) {
          smallest = smallest.left;
        }
        root.key = smallest.key;
        root.right = deleteTree(root.right, root.key);
      }
    }
    return root;
  }
}

