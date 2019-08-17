/*
Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if there is no cycle.
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
  public ListNode cycleNode(ListNode head) {
    if (head == null) return null;
    Set<ListNode> set = new HashSet<>();
    ListNode cur = head;
    set.add(cur);
    while (cur.next != null) {
      if (!set.add(cur.next)) {
        return cur.next;
      }
      cur = cur.next;
    }
    return null;
  }
}
