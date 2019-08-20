/*
We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers. In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of the two piles. We merge the piles of stones until we have only one pile left. Determine the minimum total cost.

Assumptions

stones is not null and is length of at least 1

Examples

{4, 3, 3, 4}, the minimum cost is 28

merge first 4 and first 3, cost 7

merge second 3 and second 4, cost 7

merge two 7s, cost 14

total cost = 7 + 7 + 14 = 28
*/

public class Solution {
  public int minCost(int[] stones) {
    //m[i][j] = min(m[i][k] + m[k+1][j]) + sum(i, j)
    int[][] sumWeight = new int[stones.length][stones.length];
    int[][] minCost = new int[stones.length][stones.length];
    for (int gap = 0; gap < stones.length; gap++) {
      for (int i = 0; i + gap < stones.length; i++) {
        int j = i + gap;
        minCost[i][j] = (gap == 0)? 0 : Integer.MAX_VALUE;
        sumWeight[i][j] = (gap == 0)? stones[i] : stones[j] + sumWeight[i][j - 1];
        for (int k = i; k < j; k++) {
          minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k + 1][j] + sumWeight[i][j]);
        }
      }
    }
    return minCost[0][stones.length - 1];
  }
}
