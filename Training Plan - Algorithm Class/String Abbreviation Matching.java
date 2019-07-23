/*
Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

Assumptions:

The original string only contains alphabetic characters.
Both input and pattern are not null.
Pattern would not contain invalid information like "a0a","0".

Examples:

pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
*/

public class Solution {
  public boolean match(String input, String pattern) {
    int idxStr = 0;
    for (int idxPat = 0; idxPat < pattern.length(); idxPat++) {
      char c = pattern.charAt(idxPat);
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        if (idxStr >= input.length() || input.charAt(idxStr) != c) return false;
        idxStr++;
      } else {
        int[] res = getNumber(pattern, idxPat);
        idxStr += res[1];
        idxPat += res[0] - 1;
      }
    }
    return idxStr == input.length();
  }
  private int[] getNumber(String pattern, int index) {
    int[] res = new int[2];
    while (index < pattern.length() && pattern.charAt(index) >= '0' && pattern.charAt(index) <='9') {
      res[0] = res[0] + 1;
      res[1] = res[1] * 10 + (pattern.charAt(index) - '0');
      index++;
    }
    return res;
  }
}
