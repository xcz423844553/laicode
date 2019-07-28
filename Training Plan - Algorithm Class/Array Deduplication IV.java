/*
Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.

Do this in-place, using the left side of the original array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
*/

public class Solution {
  public int[] dedup(int[] array) {
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (slow == 0 || array[slow - 1] != array[fast]) {
        array[slow++] = array[fast];
      } else {
        int end = fast + 1;
        while (end < array.length && array[end] == array[fast]) {
          end++;
        }
        fast = end - 1;
        slow--;
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
