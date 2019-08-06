/*
Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. Find the coordinates of the points that is k-th closest to <0,0,0>.

We are using euclidean distance here.

Assumptions

The three given arrays are not null or empty, containing only non-negative numbers
K >= 1 and K <= a.length * b.length * c.length

Return

a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array

Examples

A = {1, 3, 5}, B = {2, 4}, C = {3, 6}

The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)

The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
*/

public class Solution {
  public List<Integer> closest(final int[] a, final int[] b, final int[] c, int k) {
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> l1, List<Integer> l2) {
        int dist1 = a[l1.get(0)] * a[l1.get(0)] + b[l1.get(1)] * b[l1.get(1)] + c[l1.get(2)] * c[l1.get(2)];
        int dist2 = a[l2.get(0)] * a[l2.get(0)] + b[l2.get(1)] * b[l2.get(1)] + c[l2.get(2)] * c[l2.get(2)];
        if (dist1 == dist2) return 0;
        return dist1 < dist2 ? -1 : 1; 
      }
    });
    Set<List<Integer>> visited = new HashSet<>();
    pq.offer(Arrays.asList(new Integer[]{0, 0, 0}));
    visited.add(Arrays.asList(new Integer[]{0, 0, 0}));
    for (int i = 0; i < k - 1; i++) {
      List<Integer> list = pq.poll();
      if (list.get(0) + 1 < a.length && visited.add(Arrays.asList(new Integer[]{list.get(0) + 1, list.get(1), list.get(2)}))) {
        pq.offer(Arrays.asList(list.get(0) + 1, list.get(1), list.get(2)));
      }
      if (list.get(1) + 1 < b.length && visited.add(Arrays.asList(new Integer[]{list.get(0), list.get(1) + 1, list.get(2)}))) {
        pq.offer(Arrays.asList(list.get(0), list.get(1) + 1, list.get(2)));
      }
      if (list.get(2) + 1 < c.length && visited.add(Arrays.asList(new Integer[]{list.get(0), list.get(1), list.get(2) + 1}))) {
        pq.offer(Arrays.asList(list.get(0), list.get(1), list.get(2) + 1));
      }
    }
    List<Integer> index = pq.poll();
    Integer[] res = new Integer[]{a[index.get(0)], b[index.get(1)], c[index.get(2)]};
    return Arrays.asList(res);
  }
}
