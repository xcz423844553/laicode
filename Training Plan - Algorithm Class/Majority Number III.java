/*
Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.

Assumptions

The given array is not null or empty
K >= 2

Examples

A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
A = {2, 1}, K = 2, return []
*/

public class Solution {
  public List<Integer> majority(int[] array, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(array[i])) {
        map.put(array[i], map.get(array[i]) + 1);
      } else if (map.size() < k - 1) {
        map.put(array[i], 1);
      } else {
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
          Map.Entry<Integer, Integer> e = it.next();
          if (e.getValue() == 1) {
            it.remove();
          } else {
            e.setValue(e.getValue() - 1);
          }
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      e.setValue(0);
    }
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(array[i])) {
        map.put(array[i], map.get(array[i]) + 1);
      }
    }
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      if (e.getValue() > array.length / k) {
        result.add(e.getKey());
      }
    }
    return result;
  }
}
