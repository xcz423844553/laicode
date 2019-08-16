/*
Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can form a set such that any pair of points in the set can form a line with positive slope. Return the size of such a maximal set.

Assumptions

The given array is not null
Note: if there does not even exist 2 points can form a line with positive slope, should return 0.

Examples

<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.
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

// Solution 1
public class Solution {
  public int largest(Point[] points) {
    if (points == null || points.length == 0) return 0;
    quickSort(points, 0, points.length - 1);
    int[] m = new int[points.length];
    int max = 0;
    for (int i = 0; i < points.length; i++) {
      m[i] = 1;
      for (int j = 0; j < i; j++) {
        if (points[i].y > points[j].y) {
          m[i] = Math.max(m[i], m[j] + 1);
          max = Math.max(m[i], max);
        }
      }
    }
    return max;
  }
  private void quickSort(Point[] points, int left, int right) {
    if (left >= right) return;
    int pivotIndex = left + new Random().nextInt(right - left + 1);
    int pivotValue = points[pivotIndex].x;
    swap(points, pivotIndex, right);
    int idxRight = right - 1;
    int idxLeft = left;
    while (idxLeft <= idxRight) {
      if (points[idxLeft].x < pivotValue) {
        idxLeft++;
      } else {
        swap(points, idxLeft, idxRight--);
      }
    }
    swap(points, idxLeft, right);
    quickSort(points, left, idxLeft - 1);
    quickSort(points, idxLeft + 1, right);
  }
  private void swap(Point[] points, int i1, int i2) {
    Point temp = points[i1];
    points[i1] = points[i2];
    points[i2] = temp;
  }
}

// Solution 2
public class Solution {
  public int largest(Point[] points) {
    if (points.length < 2) return 0;
    quickSort(points, 0, points.length - 1);
    int[] refineY = new int[points.length];
    int range = 0;
    for (int i = 0; i < points.length; i++) {
      int tarY = points[i].y;
      if (range == 0 || tarY > refineY[range - 1]) {
        refineY[range++] = tarY;
      } else {
        int index = binarySearchSmallestLargerOrEqual(refineY, range, tarY);
        refineY[index] = tarY;
      }
    }
    return range == 1? 0 : range;
  }
  private int binarySearchSmallestLargerOrEqual(int[] refineY, int range, int tarY) {
    int left = 0;
    int right = range - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (refineY[mid] < tarY) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
  private void quickSort(Point[] points, int left, int right) {
    if (left >= right) return;
    int pivot = left + new Random().nextInt(right - left + 1);
    int pivotX = points[pivot].x;
    swap(points, pivot, right);
    int i = left;
    int j = right - 1;
    while (i <= j) {
      if (points[i].x <= pivotX) {
        i++;
      } else {
        swap(points, i, j--);
      }
    }
    swap(points, i, right);
    quickSort(points, left, i - 1);
    quickSort(points, i + 1, right);
    return;
  }
  private void swap(Point[] points, int i1, int i2) {
    Point p = points[i1];
    points[i1] = points[i2];
    points[i2] = p;
  }
}
