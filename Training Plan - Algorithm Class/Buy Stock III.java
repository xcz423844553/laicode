/*
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, at any time you can only hold at most one unit of stock, and you can make at most 2 transactions in total. Determine the maximum profit you can make.

Assumptions

The give array is not null and is length of at least 2

Examples

{2, 3, 2, 1, 4, 5, 2, 11}, the maximum profit you can make is (5 - 1) + (11 - 2) = 13
*/

public class Solution {
  public int maxProfit(int[] array) {
    int[][] m = new int[array.length][2];
    m[0][0] = 0;
    m[0][1] = 0;
    int minLeft = array[0];
    for (int i = 1; i < array.length; i++) {
      m[i][0] = Math.max(m[i - 1][0], array[i] - minLeft);
      minLeft = Math.min(minLeft, array[i]);
    }
    for (int i = 1; i < array.length; i++) {
      m[i][1] = Math.max(m[i][0], m[i - 1][1]);
      for (int j = 1; j + 1 < i; j++) {
        int profit = array[i] - array[j + 1];
        if (profit < 0) profit = 0;
        m[i][1] = Math.max(m[i][1], m[j][0] + profit);
      }
    }
    return m[array.length - 1][1];
  }
}

