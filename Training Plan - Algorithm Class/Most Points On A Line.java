/*
Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can be crossed by a single line in 2D space.

Assumptions

The given array is not null and it has at least 2 points

Examples

<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
*/

/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int most(Point[] points) {
    Map<List<Double>, Set<Integer>> col1 = new HashMap<>();
    Map<Integer, Set<Integer>> col2 =  new HashMap();
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        Point p1 = points[i];
        Point p2 = points[j];
        Set<Integer> index = null;
        if (p1.x == p2.x) {
          index = col2.get(p1.x);
          if (index == null) {
            index = new HashSet<Integer>();
            col2.put(p1.x, index);
          }
        } else {
          Double k = (p1.y - p2.y) * 1.0 / (p1.x - p2.x);
          Double b = p1.y - k * p1.x;
          index = col1.get(Arrays.asList(k, b));
          if (index == null) {
            index = new HashSet<Integer>();
            col1.put(Arrays.asList(k, b), index);
          }
        }
        index.add(i);
        index.add(j);
      }
    }
    int max = 0;
    for (Set<Integer> val : col1.values()) {
      max = Math.max(max, val.size());
    }
    for (Set<Integer> val : col2.values()) {
      max = Math.max(max, val.size());
    }
    return max;
  }
}
