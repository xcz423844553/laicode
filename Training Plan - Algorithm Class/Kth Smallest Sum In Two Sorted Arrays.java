/*
Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, where a is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.

Assumptions

A is not null and A is not of zero length, so as B
K > 0 and K <= m * n

Examples

A = {1, 3, 5}, B = {4, 8}

1st smallest s is 1 + 4 = 5
2nd smallest s is 3 + 4 = 7
3rd, 4th smallest s are 9 (1 + 8, 4 + 5) 
5th smallest s is 3 + 8 = 11
*/

public class Solution {
  public int kthSum(int[] A, int[] B, int k) {
    int m = A.length;
    int n = B.length;
    boolean[][] visited = new boolean[m][n];
    PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
      @Override
      public int compare(Element e1, Element e2) {
        if (e1.val == e2.val) return 0;
        return e1.val > e2.val ? 1 : -1;
      }
    });
    pq.offer(new Element(A[0] + B[0], 0, 0));
    visited[0][0] = true;
    while (!pq.isEmpty() && k > 1) {
      Element e = pq.poll();
      if (e.a + 1 < m && !visited[e.a + 1][e.b]) {
        pq.offer(new Element(A[e.a + 1] + B[e.b], e.a + 1, e.b));
        visited[e.a + 1][e.b] = true;
      }
      if (e.b + 1 < n && !visited[e.a][e.b + 1]) {
        pq.offer(new Element(A[e.a] + B[e.b + 1], e.a, e.b + 1));
        visited[e.a][e.b + 1] = true;
      }
      k--;
    }
    return pq.poll().val;
  }

  class Element {
    public int val;
    public int a;
    public int b;
    public Element(int val, int a, int b) {
      this.val = val;
      this.a = a;
      this.b = b;
    }
  }
}
