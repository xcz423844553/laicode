/*
Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.

Assumptions

The given array is not null and has length of at least 3
No duplicate triples should be returned, order of the values in the tuple does not matter

Examples

A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
*/

public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(array);
    for (int i = 0; i < array.length; i++) {
      if (i != 0 && array[i] == array[i - 1]) continue;
      int left = i + 1;
      int right = array.length - 1;
      while (left < right) {
        int sum = array[left] + array[right] + array[i];
        if (sum > target) {
          right--;
        } else if (sum < target) {
          left++;
        } else {
          res.add(Arrays.asList(new Integer[]{array[left], array[right], array[i]}));
          int l = array[left];
          int r = array[right];
          while (left < array.length && array[left] == l) {
            left++;
          }
          while (right >= 0 && array[right] == r) {
            right--;
          }
        }
      }
    }
    return res;
  }
}
