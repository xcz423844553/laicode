/*
Return the number of nodes in the linked list.

Examples

L = null, return 0
L = 1 -> null, return 1
L = 1 -> 2 -> null, return 2
*/

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public int numberOfNodes(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }
}
