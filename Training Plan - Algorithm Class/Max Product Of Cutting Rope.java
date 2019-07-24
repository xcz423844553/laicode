/*
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

Assumptions

n >= 2

Examples

n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
*/

public class Solution {
  public int maxProduct(int length) {
    // i = length of rope
    // m[i] = max product of cutting a i-long rope
    // m[i] = max(m[j] * (i - j)) for j < i    
    int[] m = new int[length + 1];
    m[1] = 1;
    for (int i = 2; i <= length; i++) {
      int max = 0;
      for (int j = i - 1; j > 0; j--) {
        max = Math.max(j * (i - j), max);
        max = Math.max(m[j] * (i - j), max);
      }
      m[i] = max;
    }
    return m[length];
  }
}
