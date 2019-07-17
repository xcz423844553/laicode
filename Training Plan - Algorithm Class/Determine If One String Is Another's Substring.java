/*
Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assumptions

Both large and small are not null
If small is empty string, return 0

Examples

“ab” is a substring of “bcabc”, return 2
“bcd” is not a substring of “bcabc”, return -1
"" is substring of "abc", return 0
*/

public class Solution {
  public int strstr(String large, String small) {
    if (small.length() == 0) return 0;
    for (int i = 0; i < large.length(); i++) {
      if (isSubstring(large, small, i)) return i;
    }
    return -1;
  }
  private boolean isSubstring(String large, String small, int start) {
    if (start + small.length() - 1 >= large.length()) return false;
    for (int i = 0; i < small.length(); i++) {
      if (large.charAt(start + i) != small.charAt(i)) return false;
    } 
    return true;
  }
}
