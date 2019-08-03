/*
Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree

Examples

levelorder traversal = {5, 3, 8, 1, 4, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5
      /    \
    3        8
  /   \        \
1      4        11

How is the binary tree represented?

We use  level order traversal sequence with a special symbol "#" denoting the null node.

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
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    List<Integer> lvlOrder = new ArrayList<>();
    Map<Integer, Integer> index = new HashMap<>();
    for (int i = 0; i < levelOrder.length; i++) {
      lvlOrder.add(levelOrder[i]);
      index.put(inOrder[i], i);
    }
    return reconstruct(lvlOrder, index);
  }
  private TreeNode reconstruct(List<Integer> levelOrder, Map<Integer, Integer> index) {
    if (levelOrder.isEmpty()) return null;
    TreeNode root = new TreeNode(levelOrder.get(0));
    levelOrder.remove(0);
    int rootIndex = index.get(root.key);
    List<Integer> leftLevelOrder = new ArrayList<>();
    List<Integer> rightLevelOrder = new ArrayList<>();
    for (int i = 0; i < levelOrder.size(); i++) {
      Integer n = levelOrder.get(i);
      if (index.get(n) < rootIndex) {
        leftLevelOrder.add(n);
      } else {
        rightLevelOrder.add(n);
      }
    }
    root.left = reconstruct(leftLevelOrder, index);
    root.right = reconstruct(rightLevelOrder, index);
    return root;
  }
}
