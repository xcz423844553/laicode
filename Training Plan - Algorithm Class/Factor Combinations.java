/*
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3
              = 2 x 2 x 6
              = 2 x 3 x 4
              = 2 x 12
              = 3 x 8
              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
*/

public class Solution {
  public List<List<Integer>> combinations(int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    combinations(target, target, new ArrayList<Integer>(), result);
    return result;
  }
  private void combinations(int target, int maxFactor, List<Integer> factors, List<List<Integer>> result) {
    if (target == 1) {
      if (factors.size() > 1) result.add(new ArrayList<Integer>(factors));
      return;
    }
    for (int i = maxFactor; i > 1; i--) {
      if (target % i == 0) {
        factors.add(i);
        combinations(target / i, i, factors, result);
        factors.remove(factors.size() - 1);
      }
    }
  }
}
