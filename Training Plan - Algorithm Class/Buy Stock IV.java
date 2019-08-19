/*
Given an array of integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, and at any time you can only hold at most one unit of stock, and you can make at most K transactions in total. Determine the maximum profit you can make.

Assumptions

The give array is not null and is length of at least 2

Examples

{2, 3, 2, 1, 4, 5, 2, 11}, K = 3, the maximum profit you can make is (3 - 2) + (5 - 1) + (11 - 2)= 14
*/

public class Solution {
  public int maxProfit(int[] array, int k) {
    int[][] m = new int[array.length][k];
    for (int i = 0; i < k; i++) {
      m[0][i] = 0;
    }
    int minLeft = array[0];
    for (int i = 1; i < array.length; i++) {
      m[i][0] = Math.max(m[i - 1][0], array[i] - minLeft);
      minLeft = Math.min(minLeft, array[i]);
    }
    for (int t = 1; t < k; t++) {
      for (int i = 1; i < array.length; i++) {
        m[i][t] = Math.max(m[i][t - 1], m[i - 1][t]);
        for (int j = 1; j + 1 < i; j++) {
          int profit = array[i] - array[j + 1];
          if (profit < 0) profit = 0;
          m[i][t] = Math.max(m[i][t], m[j][t - 1] + profit);
        }
      }
    }
    return m[array.length - 1][k - 1];
  }
}
