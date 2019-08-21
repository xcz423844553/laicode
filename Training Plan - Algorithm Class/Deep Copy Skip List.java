/*
A Skip List is a special type of linked list, where each of the nodes has a forward pointer to another node in the front and forward pointers are guaranteed to be in non-descending order.

Make a deep copy of the original skip list.
*/


/**
 * class SkipListNode {
 *   public int value;
 *   public SkipListNode next;
 *   public SkipListNode forward;
 *   public SkipListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public SkipListNode copy(SkipListNode head) {
    if (head == null) return null;
    Map<SkipListNode, SkipListNode> map = new HashMap<>();
    SkipListNode dummy = new SkipListNode(0);
    SkipListNode newCur = dummy;
    SkipListNode cur = head;
    while (cur != null) {
      SkipListNode copy = map.get(cur);
      if (copy == null) {
        copy = new SkipListNode(cur.value);
        map.put(cur, copy);
      }
      SkipListNode forward = cur.forward == null ? null : map.get(cur.forward);
      if (cur.forward != null && forward == null) {
        forward = new SkipListNode(cur.forward.value);
        map.put(cur.forward, forward);
      }
      copy.forward = forward;
      newCur.next = copy;
      newCur = copy;
      cur = cur.next;
    }
    return dummy.next;
  }
}
