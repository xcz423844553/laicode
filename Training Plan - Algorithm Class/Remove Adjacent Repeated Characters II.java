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
    char[] array = new char[input.length];
    for (int fast = 0; fast < input.length(); fast++) {
      if (slow < 2 || input.charAt(slow - 2) != input.charAt(fast)) {
        array[slow++] = array[fast];
      }
    }
    return new String(array);
  }
}
