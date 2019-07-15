/*
Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.

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
    if (head == null) return head;
    ListNode dummySm = new ListNode(0);
    ListNode dummyLg = new ListNode(0);
    ListNode curSm = dummySm;
    ListNode curLg = dummyLg;
    ListNode cur = head;
    while (cur != null) {
      if (cur.value < target) {
        curSm.next = cur;
        curSm = curSm.next;
        cur = cur.next;
        curSm.next = null;
      } else {
        curLg.next = cur;
        curLg = curLg.next;
        cur = cur.next;
        curLg.next = null;
      }
    }
    curSm.next = dummyLg.next;
    return dummySm.next;
  }
}
