/*
Determine if the characters of a given string are all unique.

Assumptions

We are using ASCII charset, the value of valid characters are from 0 to 255
The given string is not null

Examples

all the characters in "abA+\8" are unique
"abA+\a88" contains duplicate characters
*/

public class Solution {
  public boolean allUnique(String word) {
    int[] bits = new int[8];
    for (int i = 0; i < word.length(); i++) {
      int row = word.charAt(i) / 32;
      int col = word.charAt(i) % 32;
      if ((bits[row] & (1 << col)) != 0) return false;
      bits[row] = bits[row] | (1 << col);
    }
    return true;
  }
}
