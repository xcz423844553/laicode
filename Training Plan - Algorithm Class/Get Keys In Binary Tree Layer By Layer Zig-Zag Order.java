/*
Get the list of keys in a given binary tree layer by layer in zig-zag order.

Examples

        5
      /    \
    3        8
  /   \        \
 1     4        11

the result is [5, 3, 8, 11, 4, 1]

Corner Cases

What if the binary tree is null? Return an empty list in this case.
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
  public List<Integer> zigZag(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    if (root == null) return list;
    Deque<TreeNode> q = new LinkedList<>();
    int level = 0;
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = null;
        if (level % 2 == 0) {
          node = q.pollFirst();
          if (node.right != null) q.offerLast(node.right);
          if (node.left != null) q.offerLast(node.left);
        } else {
          node = q.pollLast();
          if (node.left != null) q.offerFirst(node.left);
          if (node.right != null) q.offerFirst(node.right);
        }
        list.add(node.key);
      }
      level++;
    }
    return list;
  }
}
