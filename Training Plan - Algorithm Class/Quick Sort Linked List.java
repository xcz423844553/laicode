/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The quick sort algorithm should be used to solve this problem.

Examples

null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
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
  public ListNode quickSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNodeWrapper wrap = copyAndReverse(head);
    quickSort(head, wrap);
    return head;
  }
  private void quickSort(ListNode head, ListNodeWrapper wrap) {
    if (head == wrap.node) return;
    ListNode pivot = head;
    ListNode left = head.next;
    ListNodeWrapper right = wrap;
    while (left != right.node) {
      if (left.value < pivot.value) {
        left = left.next;
      } else {
        swap(left, right);
        right = right.next;
      }
    }
    ListNode mid = null;
    ListNodeWrapper midWrap = null;
    if (left.value < pivot.value) {
      swap(pivot, right);
      mid = left;
      midWrap = right;
    } else {
      swap(pivot, right.next);
      mid = right.next.node;
      midWrap = right.next;
    }
    if (mid != wrap.node) quickSort(mid.next, wrap);
    if (mid != head) quickSort(head, midWrap.next);
  }
  private ListNodeWrapper copyAndReverse(ListNode head) {
    ListNodeWrapper newHead = null;
    ListNode cur = head;
    while (cur != null) {
      ListNodeWrapper copy = new ListNodeWrapper(cur, newHead);
      newHead = copy;
      cur = cur.next;
    }
    return newHead;
  }
  private void swap(ListNode n1, ListNodeWrapper n2) {
    if (n1 == null || n2.node == null) return;
    int temp = n1.value;
    n1.value = n2.node.value;
    n2.node.value = temp;
  }
  class ListNodeWrapper {
    public ListNode node;
    public ListNodeWrapper next;
    public ListNodeWrapper(ListNode node, ListNodeWrapper next) {
      this.node = node;
      this.next = next;
    }
  }
}
