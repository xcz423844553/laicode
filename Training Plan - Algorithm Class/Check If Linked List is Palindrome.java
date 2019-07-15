/*
Given a linked list, check whether it is a palindrome.

Examples:

Input:   1 -> 2 -> 3 -> 2 -> 1 -> null

output: true.

Input:   1 -> 2 -> 3 -> null  

output: false.

Requirements:

Space complexity must be O(1)
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
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    ListNode mid = findMid(head);
    ListNode tail = mid.next;
    mid.next = null;
    tail = reverse(tail);
    ListNode curHead = head;
    ListNode curTail = tail;
    while (curHead != null && curTail != null) {
      if (curHead.value != curTail.value) {
        return false;
      }
      curHead = curHead.next;
      curTail = curTail.next;
    }
    return true;
  }
  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
