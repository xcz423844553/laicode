/*
Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

Assumptions

The given array is not null and has length of at least 2.

Examples

A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
*/

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      List<Integer> list = map.get(array[i]);
      if (list == null) {
        list = new ArrayList<>();
        list.add(i);
        map.put(array[i], list);
      } else {
        list.add(i);
      }
    }
    for (int i = 0; i < array.length; i++) {
      List<Integer> list = map.get(target - array[i]);
      if (list != null) {
        for (Integer j : list) {
          if (j > i) {
            res.add(Arrays.asList(new Integer[]{i, j}));
          }
        }
      }
    }
    return res;
  }
}
