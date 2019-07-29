/*
Merge K sorted array into one big sorted array in ascending order.

Assumptions

The input arrayOfArrays is not null, none of the arrays is null either.
*/

public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    if (arrayOfArrays.length == 0) return new int[]{};
    int len = 0;
    for (int i = 0; i < arrayOfArrays.length; i++) {
      len += arrayOfArrays[i].length;
    }
    int[] res = new int[len];
    PriorityQueue<Element> pq = new PriorityQueue(new Comparator<Element>() {
      @Override
      public int compare(Element e1, Element e2) {
        if (e1.value == e2.value) return 0;
        return e1.value < e2.value ? -1 : 1;
      }
    });
    for (int i = 0; i < arrayOfArrays.length; i++) {
      if (arrayOfArrays[i].length > 0) pq.offer(new Element(arrayOfArrays[i][0], i, 0));
    }
    for (int i = 0; i < len; i++) {
      Element e = pq.poll();
      res[i] = e.value;
      if (e.y + 1 < arrayOfArrays[e.x].length) {
        pq.offer(new Element(arrayOfArrays[e.x][e.y + 1], e.x, e.y + 1));
      }
    }
    return res;
  }
  class Element {
    int value;
    int x;
    int y;
    Element(int value, int x, int y) {
      this.value = value;
      this.x = x;
      this.y = y;
    }
  }
}
