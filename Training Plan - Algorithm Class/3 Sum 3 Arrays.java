/*
Given three arrays, determine if a set can be made by picking one element from each array that sums to the given target number.

Assumptions

The three given arrays are not null and have length of at least 1

Examples

A = {1, 3, 5}, B = {8, 2}, C = {3}, target = 14, return true(pick 3 from A, pick 8 from B and pick 3 from C)
*/

public class Solution {
  public boolean exist(int[] a, int[] b, int[] c, int target) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        set.add(a[i] + b[j]);
      }
    }
    for (int i = 0; i < c.length; i++) {
      if (set.contains(target - c[i])) return true;
    }
    return false;
  }
}
