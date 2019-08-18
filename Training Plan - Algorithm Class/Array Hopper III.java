/*
Given an array of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). Determine the minimum number of jumps you need to jump out of the array.

By jump out, it means you can not stay at the end of the array. Return -1 if you can not do so.

Assumptions

The given array is not null and has length of at least 1.

Examples

{1, 3, 2, 0, 2}, the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out)

{3, 2, 1, 1, 0}, you are not able to jump out of array, return -1 in this case.
*/

public class Solution {
  public int minJump(int[] array) {
    //m[i]: the min steps to jump to i
    //m[i] = min{m[j]} + 1 if a[j] + j >= i
    if (array == null || array.length == 0) return 0;
    int[] m = new int[array.length + 1];
    m[0] = 0;
    for (int i = 1; i <= array.length; i++) {
      m[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (m[j] != -1 && array[j] + j >= i) {
          m[i] = Math.min(m[i], m[j] + 1);
        }
      }
      if (m[i] == Integer.MAX_VALUE) m[i] = -1;
    }
    return m[array.length];
  }
}
