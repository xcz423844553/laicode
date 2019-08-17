/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The selectoin sort algorithm should be used to solve this problem.

Examples

null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to 2 -> 3 -> 4 -> 5 -> 6
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
  public ListNode selectionSort(ListNode head) {
    if (head == null) return head;
    ListNode unSorted = head;
    while (unSorted.next != null) {
      ListNode cur = unSorted;
      ListNode minNode = cur;
      while (cur != null) {
        if (cur.value < minNode.value) {
          minNode = cur;
        }
        cur = cur.next;
      }
      int temp = unSorted.value;
      unSorted.value = minNode.value;
      minNode.value = temp;
      unSorted = unSorted.next;
    }
    return head;
  }
}
