/*
In URL encoding, whenever we see an space " ", we need to replace it with "20%". Provide a method that performs this encoding for a given string.

Examples

"google/q?flo wer market" → "google/q?flo20%wer20%market"

Corner Cases

If the given string is null, we do not need to do anything.
*/

public class Solution {
  public String encode(String input) {
    if (input == null || input.length() == 0) return input;
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        count++;
      }
    }
    char[] array = new char[input.length() + 2 * count];
    int slow = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        array[slow++] = '2';
        array[slow++] = '0';
        array[slow++] = '%';
      } else {
        array[slow++] = input.charAt(i);
      }
    }
    return new String(array);
  }
}
