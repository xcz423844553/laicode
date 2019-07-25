/*
Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions

The given array is not null

Examples

{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
*/

public class Solution {
  public int longest(int[] array) {
    int len = 0;
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      if (i == 0) {
        len = array[i];
      } else if (array[i] == 0) {
        len = 0;
      } else {
        len++;
      }
      max = Math.max(max, len);
    }
    return max;
  }
}
