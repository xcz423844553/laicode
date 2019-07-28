/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null

Examples

{1, 2, 2, 3, 3, 3} → {1}
*/

public class Solution {
  public int[] dedup(int[] array) {
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      int end = fast + 1;
      while (end < array.length && array[end] == array[fast]) {
        end++;
      }
      if (end - fast == 1) {
        array[slow++] = array[fast];
      } else {
        fast = end - 1;
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
