/*
Given an integer array A, A is sorted in ascending order first then shifted by an arbitrary number of positions, For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index of the smallest number.

Assumptions

There are no duplicate elements in the array

Examples

A = {3, 4, 5, 1, 2}, return 3
A = {1, 2, 3, 4, 5}, return 0

Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.
*/

public class Solution {
  public int shiftPosition(int[] array) {
    if (array == null || array.length == 0) return -1;
    return shiftPosition(array, 0, array.length - 1);
  }
  private int shiftPosition(int[] array, int left, int right) {
    if (left == right) return left;
    int mid = left + (right - left) / 2;
    if (array[mid] > array[right]) {
      return shiftPosition(array, mid + 1, right);
    } else {
      return shiftPosition(array, left, mid);
    }
  }
}

