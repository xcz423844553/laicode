/*
Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

Assumptions

Both strings are not null

Examples

string one: “sigh”, string two : “asith”

the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
*/

public class Solution {
  public int editDistance(String one, String two) {
    int[][] m = new int[one.length() + 1][two.length() + 1];
    for (int i = 0; i < one.length() + 1; i++) {
      for (int j = 0; j < two.length() + 1; j++) {
        if (i == 0 || j == 0) {
          m[i][j] = i == 0 ? j : i;
        } else {
          m[i][j] = m[i - 1][j - 1] + (one.charAt(i - 1) == two.charAt(j - 1) ? 0 : 1);
          m[i][j] = Math.min(m[i - 1][j] + 1, m[i][j]);
          m[i][j] = Math.min(m[i][j - 1] + 1, m[i][j]);
        }
      }
    }
    return m[one.length()][two.length()];
  }
}
