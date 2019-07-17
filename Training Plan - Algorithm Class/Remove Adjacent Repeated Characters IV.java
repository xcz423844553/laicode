/*
Repeatedly remove all adjacent, repeated characters in a given string from left to right.

No adjacent characters should be identified in the final string.

Examples

"abbbaaccz" → "aaaccz" → "ccz" → "z"
"aabccdc" → "bccdc" → "bdc"
*/

public class Solution {
  public String deDup(String input) {
    if (input == null || input.length() == 0) return input;
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (slow == 0 || array[fast] != array[slow - 1]) {
        array[slow++] = array[fast];
      } else {
        int j = fast + 1;
        while (j < array.length && array[j] == array[fast]) {
          j++;
        }
        slow--;
        fast = j - 1;
      }
    }
    return new String(array, 0, slow);
  }
}
