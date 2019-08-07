/*
Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.

Assumptions

The given array is not null

Examples

A = {1, 2, 1, 2, 1}, return [1, 2]
A = {1, 2, 1, 2, 3, 3, 1}, return [1]
A = {1, 2, 2, 3, 1, 3}, return []
*/

public class Solution {
  public List<Integer> majority(int[] array) {
    List<Integer> list = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      if (i == 0 || i == 1) {
        list.add(array[i]);
        count.add(1);
      } else if (array[i] == list.get(0)) {
        count.set(0, count.get(0) + 1);
      } else if (array[i] == list.get(1)) {
        count.set(1, count.get(1) + 1);
      } else if (count.get(0) == 0) {
        list.set(0, array[i]);
        count.set(0, 1);
      } else if (count.get(1) == 0) {
        list.set(1, array[i]);
        count.set(1, 1);
      } else {
        count.set(0, count.get(0) - 1);
        count.set(1, count.get(1) - 1);
      }
    }
    if (count.size() > 0) count.set(0, 0);
    if (count.size() > 1) count.set(1, 0);
    for (int i = 0; i < array.length; i++) {
      if (array[i] == list.get(0)) {
        count.set(0, count.get(0) + 1);
      } else if (array[i] == list.get(1)) {
        count.set(1, count.get(1) + 1);
      }
    }
    if (count.size() > 1 && count.get(1) <= array.length / 3) list.remove(1);
    if (count.size() > 0 && count.get(0) <= array.length / 3) list.remove(0);
    return list;
  }
}
