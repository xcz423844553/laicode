/*
Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not has any adjacent, repeated occurrences, it is not changed.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

Examples

“abbcccdeee” → “ab2c3de3”
*/

public class Solution {
  public String compress(String input) {
    if (input == null || input.length() == 0) return input;
    char[] c = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < c.length; fast++) {
      c[slow++] = c[fast];
      int end = fast;
      while (end < c.length && c[end] == c[fast]) {
        end++;
      }
      int count = end - fast;
      if (count != 1) {
        String s = String.valueOf(count);
        for (int i = 0; i < s.length(); i++) {
          c[slow++] = s.charAt(i);
        }
      }
      fast = end - 1;
    }
    return new String(c, 0, slow);
  }
}
