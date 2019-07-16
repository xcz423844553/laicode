/*
Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

Arguments

coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
target - a non-negative integer representing the target number of cents, eg. 99

Assumptions

coins is not null and is not empty, all the numbers in coins are positive
target >= 0
You have infinite number of coins for each of the denominations, you can pick any number of the coins.

Return

a list of ways of combinations of coins to sum up to be target.
each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.

Examples

coins = {2, 1}, target = 4, the return should be

[

  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)

  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)

  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)

]
*/

public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    List<List<Integer>> result = new LinkedList<>();
    dfs(target, 0, coins, new ArrayList<Integer>(), result);
    return result;
  }
  private void dfs(int target, int index, int[] coins, List<Integer>number, List<List<Integer>> list) {
    if (index == coins.length - 1) {
      if (target % coins[index] == 0) {
        number.add(target / coins[index]);
        list.add(new ArrayList(number));
        number.remove(number.size() - 1);
      }
      return;
    }
    for (int i = 0; coins[index] * i <= target; i++) {
      number.add(i);
      dfs(target - coins[index] * i, index + 1, coins, number, list);
      number.remove(number.size() - 1);
    }
  }
}
