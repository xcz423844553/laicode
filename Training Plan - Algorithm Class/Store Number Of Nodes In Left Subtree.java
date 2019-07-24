/*
Given a binary tree, count the number of nodes in each node’s left subtree, and store it in the numNodesLeft field.

Examples

                  1(6)
               /          \
           2(3)        3(0)
          /      \
      4(1)     5(0)
    /        \        \
6(0)        7(0)      8(0)

The numNodesLeft is shown in parentheses.
*/

/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    numNodes(root);    
  }
  private int numNodes(TreeNodeLeft root) {
    if (root == null) return 0;
    int left = numNodes(root.left);
    root.numNodesLeft = left;
    int right = numNodes(root.right);
    return left + right + 1;
  }
}
