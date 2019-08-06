/*
Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.

Assumptions

K >= 1

Examples

the smallest is 3 * 5 * 7 = 105
the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
the 5th smallest is 3 ^ 3 * 5 * 7 = 945
*/

public class Solution {
  public long kth(int k) {
    Set<Long> visited = new HashSet<>();
    PriorityQueue<Long> pq = new PriorityQueue<>();
    pq.offer(3 * 5 * 7L);
    visited.add(3 * 5 * 7L);
    for (int i = 0; i < k - 1; i++) {
      Long cur = pq.poll();
      if (!visited.contains(cur * 3)) {
        visited.add(cur * 3);
        pq.offer(cur * 3);
      }
      if (!visited.contains(cur * 5)) {
        visited.add(cur * 5);
        pq.offer(cur * 5);
      }
      if (!visited.contains(cur * 7)) {
        visited.add(cur * 7);
        pq.offer(cur * 7);
      } 
    }
    return pq.poll();
  }
}
