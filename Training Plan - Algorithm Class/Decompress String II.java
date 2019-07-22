/*
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

There are no adjacent repeated characters with length > 9

Examples

“a1c0b2c4” → “abbcccc”
*/

public class Solution {
  public String decompress(String input) {
    if (input == null || input.length() == 0) return input;
    int len = 0;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c >= '0' && c <= '9') {
        len += c - '0';
      }
    }
    char[] array = new char[len];
    int cur = 0;
    for (int i = 0; i < input.length(); i += 2) {
      char c = input.charAt(i);
      int num = input.charAt(i + 1) - '0';
      for (int j = 0; j < num; j++) {
        array[cur++] = c;
      }
    }
    return new String(array);
  }
}
