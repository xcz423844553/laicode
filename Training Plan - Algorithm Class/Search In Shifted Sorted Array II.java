/*
Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.

For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There could be duplicate elements in the array.

Examples

A = {3, 4, 5, 1, 2}, T = 4, return 1
A = {3, 3, 3, 1, 3}, T = 1, return 3
A = {3, 1, 3, 3, 3}, T = 1, return 1

Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.
*/

public class Solution {
  public int search(int[] array, int target) {
    if (array == null || array.length == 0) return -1;
    return search(array, target, 0, array.length - 1);
  }
  private int search(int[] array, int target, int left, int right) {
    if (left > right) return -1;
    int mid = left + (right - left) / 2;
    if (array[mid] == target) {
      return mid;
    } else if (array[mid] > array[left]) {
      if (target < array[mid] && target >= array[left]) {
        return search(array, target, left, mid - 1);
      } else {
        return search(array, target, mid + 1, right);
      }
    } else if (array[mid] < array[right]) {
      if (target > array[mid] && target <= array[right]) {
        return search(array, target, mid + 1, right);
      } else {
        return search(array, target, left, mid - 1);
      }
    } else {
      int leftSearch = search(array, target, left, mid - 1);
      int rightSearch = search(array, target, mid + 1, right);
      return leftSearch != -1 ? leftSearch : rightSearch;
    }
  }
}
