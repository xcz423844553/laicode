/*
There is a wooden stick with length L >= 1, we need to cut it into pieces, where the cutting positions are defined in an int array A. The positions are guaranteed to be in ascending order in the range of [1, L - 1]. The cost of each cut is the length of the stick segment being cut. Determine the minimum total cost to cut the stick into the defined pieces.

Examples

L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)
*/

public class Solution {
  public int minCost(int[] cuts, int length) {
    // minCost = cost[i][j] at k + minCost[i][k] + minCost[k][j];
    int[] allCuts = new int[cuts.length + 2];
    for (int i = 0; i < allCuts.length; i++) {
      if (i == 0) {
        allCuts[i] = 0;
      } else if (i == allCuts.length - 1) {
        allCuts[i] = length;
      } else {
        allCuts[i] = cuts[i - 1];
      }
    }
    int[][] cost = new int[allCuts.length][allCuts.length];
    for (int gap = 1; gap < allCuts.length; gap++) {
      for (int i = 0; i < allCuts.length - gap; i++) {
        int j = i + gap;
        cost[i][j] = gap == 1 ? 0 : Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
          cost[i][j] = Math.min(cost[i][j], allCuts[j] - allCuts[i] + cost[i][k] + cost[k][j]);
        }
      }
    }
    return cost[0][allCuts.length - 1];
  }
}
