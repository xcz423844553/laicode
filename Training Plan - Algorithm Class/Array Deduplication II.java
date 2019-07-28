/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null

Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
*/

public class Solution {
  public int[] dedup(int[] array) {
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (slow < 2 || array[slow - 2] != array[fast]) {
        array[slow++] = array[fast];
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
