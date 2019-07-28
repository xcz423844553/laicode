/*
Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.

Assumptions

The given array is not null and has length of at least 1

Examples

{2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
*/

public class Solution {
  public int[] largestAndSmallest(int[] array) {
    for (int i = 0; i <= array.length / 2; i++) {
      if (array[i] > array[array.length - 1 - i]) {
        int temp = array[i];
        array[i] = array[array.length - 1 - i];
        array[array.length - 1 - i] = temp;
      }
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= array.length / 2; i++) {
      max = Math.max(max, array[array.length - 1 - i]);
      min = Math.min(min, array[i]);
    }
    return new int[]{max, min};
  }
}
