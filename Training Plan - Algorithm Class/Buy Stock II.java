/*
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, you can make as many transactions you want, but at any time you can only hold at most one unit of stock. Determine the maximum profit you can make.

Assumptions

The give array is not null and is length of at least 2

Examples

{2, 3, 2, 1, 4, 5}, the maximum profit you can make is (3 - 2) + (5 - 1) = 5
*/

public class Solution {
  public int maxProfit(int[] array) {
    int[] m = new int[array.length];
    m[0] = 0;
    for (int i = 1; i < array.length; i++) {
      m[i] = (array[i] - array[0] > 0) ? array[i] - array[0] : 0;
      m[i] = Math.max(m[i], m[i - 1]);
      for (int j = 0; j + 1 < i; j++) {
        int profit = array[i] - array[j + 1];
        if (profit < 0) profit = 0;
        m[i] = Math.max(m[i], m[j] + profit);
      }
    }
    return m[array.length - 1];
  }
}
