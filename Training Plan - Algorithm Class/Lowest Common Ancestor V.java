/*
Given two nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

-There is no parent pointer for the nodes in the K-nary tree.

-The given two nodes are guaranteed to be in the K-nary tree.

Examples

        5
      /   \
     9   12
   / | \      \
 1   2   3      14

The lowest common ancestor of 2 and 14 is 5.

The lowest common ancestor of 2 and 9 is 9.
*/

/**
 * public class KnaryTreeNode {
 *     int key;
 *     List<KnaryTreeNode> children;
 *     public KnaryTreeNode(int key) {
 *         this.key = key;
 *         this.children = new ArrayList<>();
 *     }
 * }
 */
public class Solution {
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
    if (root == null || root == a || root == b) return root;
    List<KnaryTreeNode> lcas = new ArrayList<>();
    for (KnaryTreeNode child : root.children) {
      KnaryTreeNode lca = lowestCommonAncestor(child, a, b);
      if (lca != null) lcas.add(lca);
    }
    if (lcas.size() == 0) {
      return null;
    } else if (lcas.size() == 1) {
      return lcas.get(0);
    } else {
      return root;
    }
  }
}
