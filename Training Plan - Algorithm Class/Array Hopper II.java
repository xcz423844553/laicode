/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

Assumptions

The given array is not null and has length of at least 1.

Examples

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
*/

public class Solution {
  public int minJump(int[] array) {
    //m[i] represents minimum step to reach i from 0
    //m[i] = min(m[j]) + 1 where 0 <= j < i and A[j] + j >= i and m[i] != -1
    int[] m = new int[array.length];
    m[0] = 0;
    for (int i = 1; i < array.length; i++) {
      m[i] = -1;
      for (int j = 0; j < i; j++) {
        if (array[j] + j >= i && m[j] != -1) {
          m[i] = m[i] == -1 ? m[j] + 1 : Math.min(m[i], m[j] + 1);
        }
      }
    }
    return m[array.length - 1];
  }
}
