/*
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

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
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    if (one == null || two == null) return null;
    int oneHeight = 0;
    int twoHeight = 0;
    TreeNodeP curOne = one;
    TreeNodeP curTwo = two;
    while (curOne != null) {
      oneHeight++;
      curOne = curOne.parent;
    }
    while (curTwo != null) {
      twoHeight++;
      curTwo = curTwo.parent;
    }
    curOne = one;
    curTwo = two;
    while (oneHeight >= 0 && twoHeight >= 0) {
      if (oneHeight == twoHeight) {
        if (curOne == curTwo) {
          return curOne;
        } else {
          oneHeight--;
          twoHeight--;
          curOne = curOne.parent;
          curTwo = curTwo.parent;
        }
      } else if (oneHeight > twoHeight) {
        oneHeight--;
        curOne = curOne.parent;
      } else {
        twoHeight--;
        curTwo = curTwo.parent;
      }
    }
    return null;
  }
}
