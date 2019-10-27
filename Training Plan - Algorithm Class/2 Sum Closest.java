/*
Find the pair of elements in a given array that sum to a value that is closest to the given target number. Return the values of the two numbers.

Assumptions

The given array is not null and has length of at least 2

Examples

A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].
*/

public class Solution {
  public List<Integer> closest(int[] array, int target) {
    Integer[] res = new Integer[2];
    Arrays.sort(array);
    int left = 0, right = array.length - 1;
    int diff = Integer.MAX_VALUE;
    while (left < right) {
      int sum = array[left] + array[right];
      if (Math.abs(sum - target) < diff) {
        diff = Math.abs(sum - target);
        res[0] = array[left];
        res[1] = array[right];
      }
      if (sum == target) {
        break;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return Arrays.asList(res);
  }
}
