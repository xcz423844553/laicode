/*
Remove adjacent, repeated characters in a given string, leaving only two characters for each group of such characters. The characters in the string are sorted in ascending order.

Assumptions

Try to do it in place.

Examples

“aaaabbbc” is transferred to “aabbc”
Corner Cases

If the given string is null, we do not need to do anything.
*/

public class Solution {
  public String deDup(String input) {
    if (input == null || input.length() == 0) return input;
    int slow = 0;
    char[] array = input.toCharArray();
    for (int fast = 0; fast < array.length; fast++) {
      if (slow < 2 || array[slow - 2] != array[fast]) {
        array[slow++] = array[fast];
      }
    }
    return new String(array, 0, slow);
  }
}
