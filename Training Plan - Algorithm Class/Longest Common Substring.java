/*
Find the longest common substring of two given strings.

Assumptions

The two given strings are not null

Examples

S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”
*/

public class Solution {
  public String longestCommon(String source, String target) {
    if (source.length() == 0 || target.length() == 0) return "";
    int[][] len = new int[source.length()][target.length()];
    int maxLen = 0;
    int maxLenIndex = 0;
    for (int i = 0; i < source.length(); i++) {
      for (int j = 0; j < target.length(); j++) {
        if (source.charAt(i) == target.charAt(j)) {
          len[i][j] = (i == 0 || j == 0) ? 1 : (len[i - 1][j - 1] + 1);
        }
        if (len[i][j] > maxLen) {
          maxLen = len[i][j];
          maxLenIndex = i;
        }
      }
    }
    return source.substring(maxLenIndex - maxLen + 1, maxLenIndex + 1);
  }
}
