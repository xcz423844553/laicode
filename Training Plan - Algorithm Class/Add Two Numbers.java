/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.  

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    int remainder = 0;
    while (cur1 != null || cur2 != null || remainder != 0) {
      int val1 = cur1 == null ? 0 : cur1.value;
      int val2 = cur2 == null ? 0 : cur2.value;
      int sum = val1 + val2 + remainder;
      remainder = 0;
      if (sum >= 10) {
        remainder = sum / 10;
        sum %= 10;
      }
      ListNode newNode = new ListNode(sum);
      cur.next = newNode;
      cur = cur.next;
      if (cur1 != null) cur1 = cur1.next;
      if (cur2 != null) cur2 = cur2.next;
    }
    return dummy.next;
  }
}
