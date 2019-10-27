/*
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences. If the character does not have any adjacent repeated occurrences, it is not compressed.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

There are no adjacent repeated characters with length > 9

Examples

“acb2c4” → “acbbcccc”
*/

public class Solution {
  public String decompress(String input) {
    if (input == null || input.length() == 0) return input;
    char[] c = input.toCharArray();
    int count = 0;
    for (int i = 0; i < c.length; i++) {
      if (isLetter(c[i])) {
        int num = getNumber(c, i + 1);
        count += num;
      }
    }
    char[] res = new char[count];
    int slow = 0;
    for (int i = 0; i < c.length; i++) {
      if (isLetter(c[i])) {
        int num = getNumber(c, i + 1);
        for (int k = 0; k < num; k++) {
          res[slow++] = c[i];
        }
      }
    }
    return new String(res, 0, slow);
  }
  private boolean isLetter(char c) {
    return c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A';
  }
  private int getNumber(char[] c, int i) {
    if (i >= c.length || isLetter(c[i])) return 1;
    int sum = 0;
    for (int j = i; j < c.length && !isLetter(c[j]); j++) {
      sum = sum * 10 + (c[j] - '0');
    }
    return sum;
  }
}
