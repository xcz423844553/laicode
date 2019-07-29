/*
Merge K sorted lists into one big sorted list in ascending order.

Assumptions

ListOfLists is not null, and none of the lists is null.
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
  public ListNode merge(List<ListNode> listOfLists) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1, ListNode l2) {
        if (l1.value == l2.value) return 0;
        return l1.value < l2.value ? -1 : 1;
      }
    });
    for (ListNode head : listOfLists) {
      if (head != null) pq.offer(head);
    }
    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      if (node.next != null) pq.offer(node.next);
      cur.next = node;
      cur = cur.next;
    }
    return dummy.next;
  }
}
