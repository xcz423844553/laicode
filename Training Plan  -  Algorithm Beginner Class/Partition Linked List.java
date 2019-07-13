/*
Given a linked list and a target value T, partition it such that all nodes less than T are 
listed before the nodes larger than or equal to target value T. 
The original relative order of the nodes in each of the two partitions should be preserved.

Examples

L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
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
  public ListNode partition(ListNode head, int target) {
    ListNode dummySm = new ListNode(0);
    ListNode dummyLg = new ListNode(0);
    ListNode tailSm = dummySm;
    ListNode tailLg = dummyLg;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      if (cur.value < target) {
        tailSm.next = cur;
        tailSm = cur;
      } else {
        tailLg.next = cur;
        tailLg = cur;
      }
      cur.next = null;
      cur = next;
    }
    tailSm.next = dummyLg.next;
    return dummySm.next;
  }
}
