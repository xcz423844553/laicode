/*
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

Assumptions

The given input string is not null.
The characters to be removed is given by another string, it is guaranteed to be not null.

Examples

input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
*/

public class Solution {
  public String remove(String input, String t) {
    if (input == null || t == null || t.length() == 0 || input.length() == 0) return input;
    Set<Character> chars = new HashSet<>();
    for (int i = 0; i < t.length(); i++) {
      chars.add(t.charAt(i));
    }
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (!chars.contains(array[fast])) {
        array[slow++] = array[fast];
      }
    }
    return new String(array, 0, slow);
  }
}
