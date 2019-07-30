/*
Determine if there exist two elements in a given array, the sum of which is the given target number.

Assumptions

The given array is not null and has length of at least 2

Examples

A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)

A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)

A = {2, 4, 1}, target = 4, return false
*/

public class Solution {
  public boolean existSum(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int sum = array[left] + array[right];
      if (target == sum) {
        return true;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return false;
  }
}
