/*
Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

Assumptions

The given array is not null and has length of at least 2
The order of the values in the pair does not matter

Examples

A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
*/

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : array) {
      Integer count = map.get(i);
      if (count == null) {
        map.put(i, 1);
      } else {
        map.put(i, count + 1);
      }
    }
    for (Integer i : map.keySet()) {
      Integer count = map.get(target - i);
      if (i < target - i && count != null) {
        res.add(Arrays.asList(new Integer[]{i, target - i}));
      } else if (i == target - i && count != null && count >= 2) {
        res.add(Arrays.asList(new Integer[]{i, i}));
      }
    }
    return res;
  }
}
