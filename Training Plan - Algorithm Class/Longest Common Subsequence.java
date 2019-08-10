/*
Find the length of longest common subsequence of two given strings.

Assumptions

The two given strings are not null

Examples

S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
*/

public class Solution {
  public int longest(String source, String target) {
    if (source.length() == 0 || target.length() == 0) return 0;
    int maxLen = 0;
    int[][] len = new int[source.length()][target.length()];
    for (int i = 0; i < source.length(); i++) {
      for (int j = 0; j < target.length(); j++) {
        len[i][j] = (i == 0 || j == 0) ? 0 : len[i - 1][j - 1];
        if (source.charAt(i) == target.charAt(j)) {
          len[i][j] = len[i][j] + 1;
        }
        maxLen = Math.max(maxLen, len[i][j]);
      }
    }
    return maxLen;
  }
}
