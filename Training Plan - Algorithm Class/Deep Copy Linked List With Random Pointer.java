/*
Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
*/

/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    if (head == null) return null;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode cur = head;
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode newCur = dummy;
    while (cur != null) {
      RandomListNode node = map.get(cur);
      if (node == null) {
        node = new RandomListNode(cur.value);
        map.put(cur, node);
      }
      newCur.next = node;
      RandomListNode next = map.get(cur.next);
      if (cur.next != null && next == null) {
        next = new RandomListNode(cur.next.value);
        map.put(cur.next, next);
      }
      node.next = next;
      RandomListNode rand = map.get(cur.random);
      if (cur.random != null && rand == null) {
        rand = new RandomListNode(cur.random.value);
        map.put(cur.random, rand);
      }
      node.random = rand;
      newCur = newCur.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
