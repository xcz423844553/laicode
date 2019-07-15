/*
Merge two sorted lists into one large sorted list.

Examples

L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
L1 = null, L2 = null, merge L1 and L2 to null
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
  public ListNode merge(ListNode one, ListNode two) {
    if (one == null) return two;
    if (two == null) return one;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    ListNode curOne = one;
    ListNode curTwo = two;
    while (curOne != null || curTwo != null) {
      if (curOne == null || (curTwo != null && curTwo.value < curOne.value)) {
        cur.next = curTwo;
        curTwo = curTwo.next;
      } else {
        cur.next = curOne;
        curOne = curOne.next;
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
