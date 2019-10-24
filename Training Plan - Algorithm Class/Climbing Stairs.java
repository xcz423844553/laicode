/*
There are in total n steps to climb until you can reach the top. You can climb 1 or 2 steps a time. Determine the number of ways you can do that.

Example:

Input: n = 4, Return 5.
*/

public class Solution {
  public int stairs(int n) {
    int s0 = 1;
    int s1 = 1;
    if (n <= 0) return 0;
    if (n == 1) return 1;
    for (int i = 2; i <= n; i++) {
      int s2 = s1 + s0;
      s0 = s1;
      s1 = s2;
    }
    return s1;
  }
}
