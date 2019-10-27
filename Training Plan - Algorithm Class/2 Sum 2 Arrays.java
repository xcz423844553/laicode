/*
Given two arrays A and B, determine whether or not there exists a pair of elements, one drawn from each array, that sums to the given target number.

Assumptions

The two given arrays are not null and have length of at least 1

Examples

A = {3, 1, 5}, B = {2, 8}, target = 7, return true(pick 5 from A and pick 2 from B)

A = {1, 3, 5}, B = {2, 8}, target = 6, return false
*/
public class Solution {
  public boolean existSum(int[] a, int[] b, int target) {
    Arrays.sort(a);
    Arrays.sort(b);
    boolean[][] visited = new boolean[a.length][b.length];
    Queue<Pair> q = new LinkedList<>();
    while (!q.isEmpty()) {
      Pair p = q.poll();
      int sum = a[p.x] + b[p.y];
      if (sum == target) {
        return true;
      } else if (sum < target) {
        if (p.x + 1 < a.length && !visited[p.x + 1][p.y]) {
          q.offer(new Pair(p.x + 1, p.y));
          visited[p.x + 1][p.y] = true;
        }
        if (p.y + 1 < b.length && !visited[p.x][p.y + 1]) {
          q.offer(new Pair(p.x, p.y + 1));
          visited[p.x][p.y + 1] = true;
        }
      } else {
        return false;
      }
    }
    return false;
  }
  class Pair {
    int x;
    int y;
    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
