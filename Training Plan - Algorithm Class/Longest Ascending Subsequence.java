/*
Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

Assumptions

A is not null

Examples

Input: A = {5, 2, 6, 3, 4, 7, 5}
Output: 4
Because [2, 3, 4, 5] is the longest ascending subsequence.
*/

// Solution 1
public class Solution {
  public int longest(int[] array) {
    if (array.length == 0) return 0;
    int[] len = new int[array.length];
    int maxLen = 1;
    for (int i = 0; i < array.length; i++) {
      len[i] = 1;
      for (int j = 0; j < i; j++) {
        if (array[j] < array[i]) {
          len[i] = Math.max(len[i], len[j] + 1);
          maxLen = Math.max(maxLen, len[i]);
        }
      }
    }
    return maxLen;
  }
}

// Solution 2
public class Solution {
  public int longest(int[] array) {
    int[] refine = new int[array.length];
    int range = 0;
    for (int i = 0; i < array.length; i++) {
      if (range == 0 || array[i] > refine[range - 1]) {
        refine[range++] = array[i];
      } else {
        int index = binarySearchSmallestLargerThanTarget(refine, range, array[i]);
        refine[index] = array[i];
      }
    }
    return range;
  }
  private int binarySearchSmallestLargerThanTarget(int[] array, int range, int target) {
    int left = 0;
    int right = range - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
