/*
Find the Kth smallest number s such that s = 2 ^ x * 3 ^ y, x >= 0 and y >= 0, x and y are all integers.

Assumptions

K >= 1

Examples

the smallest is 1
the 2nd smallest is 2
the 3rd smallest is 3
the 5th smallest is 2 * 3 = 6
the 6th smallest is 2 ^ 3 * 3 ^ 0 = 8
*/

public class Solution {
  public int kth(int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>(k);
    pq.offer(new Pair(0, 0, 1));
    boolean[][] visited = new boolean[k][k];
    while (k > 1) {
      Pair p = pq.poll();
      k--;
      if (p.x + 1 < k && !visited[p.x + 1][p.y]) {
        pq.offer(new Pair(p.x + 1, p.y, p.val * 2));
        visited[p.x + 1][p.y] = true;
      }
      if (p.y + 1 < k && !visited[p.x][p.y + 1]) {
        pq.offer(new Pair(p.x, p.y + 1, p.val * 3));
        visited[p.x][p.y + 1] = true;
      }
    }
    return pq.poll().val;
  }
  class Pair implements Comparable<Pair> {
    int x, y, val;
    Pair(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
    public int compareTo(Pair p) {
      if (p.val == this.val) return 0;
      return this.val < p.val ? -1 : 1;
    }
  }
}
