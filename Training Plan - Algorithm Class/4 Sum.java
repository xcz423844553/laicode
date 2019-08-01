/*
Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions

The given array is not null and has length of at least 4

Examples

A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

A = {1, 2, 2, 3, 4}, target = 12, return false
*/

public class Solution {
  public boolean exist(int[] array, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int j = 1; j < array.length; j++) {
      for (int i = 0; i < j; i++) {
        int sum = array[i] + array[j];
        if (map.containsKey(target - sum) && map.get(target - sum) < i) return true;
        if (!map.containsKey(sum)) map.put(sum, j);
      }
    }
    return false;
  }
}
