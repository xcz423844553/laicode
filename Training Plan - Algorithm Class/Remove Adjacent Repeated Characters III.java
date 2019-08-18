/*
Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. The characters in the string are sorted in ascending order.

Assumptions

Try to do it in place.

Examples

“aaaabbbc” is transferred to “c”
Corner Cases

If the given string is null, we do not need to do anything.
*/

public class Solution {
  public String deDup(String input) {
    if (input == null || input.length() == 0) return input;
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      int end = fast + 1;
      while (end < array.length && array[end] == array[fast]) {
        end++;
      }
      if (end == fast + 1) {
        array[slow++] = array[fast];
      }
      fast = end - 1;
    }
    return new String(array, 0, slow);
  }
}
