/*
Given a target integer T and an integer array A sorted in ascending order, Find the total number of occurrences of T in A.

Examples

A = {1, 2, 3, 4, 5}, T = 3, return 1
A = {1, 2, 2, 2, 3}, T = 2, return 3
A = {1, 2, 2, 2, 3}, T = 4, return 0

Corner Cases

What if A is null? We should return 0 in this case.
*/

public class Solution {
  public int totalOccurrence(int[] array, int target) {
    if (array == null || array.length == 0) return 0;
    int leftBound = findSmallestElementLargerThenTarget(array, target - 1, 0, array.length - 1);
    int rightBound = findSmallestElementLargerThenTarget(array, target, 0, array.length - 1);
    return rightBound - leftBound;
  }
  private int findSmallestElementLargerThenTarget(int[] array, int target, int left, int right) {
    if (left == right) return array[left] > target ? left : left + 1;
    int mid = left + (right - left) / 2;
    if (array[mid] <= target) {
      return findSmallestElementLargerThenTarget(array, target, mid + 1, right);
    } else {
      return findSmallestElementLargerThenTarget(array, target, left, mid);
    }
  }
}
