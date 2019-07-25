/*
Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Assumptions

The given array is not null and has length of at least 1.

Examples

{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

{-2, -1, -3}, the largest subarray sum is -1
*/

public class Solution {
  public int largestSum(int[] array) {
    int sum = 0;
    int max = array[0];
    for (int i = 0; i < array.length; i++) {
      if (sum > 0) {
        sum += array[i];
      } else {
        sum = array[i];
      }
      max = Math.max(max, sum);
    }
    return max;
  }
}
