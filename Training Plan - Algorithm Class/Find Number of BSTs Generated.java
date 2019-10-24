/*
Find the number of different Binary Search Trees generated from 1-n.

Example:

Input: 3, Return: 5
*/

public class Solution {
  public int numOfTrees(int n) {
    if (n < 1) return 0;
    int[] m = new int[n + 1];
    m[0] = 1;
    m[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        m[i] += m[j - 1] * m[i - j];
      }
    }
    return m[n];
  }
}
