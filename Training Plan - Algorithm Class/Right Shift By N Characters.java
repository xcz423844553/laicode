/*
Right shift a given string by n characters.

Assumptions

The given string is not null.
n >= 0.

Examples

"abc", 4 -> "cab"
*/

public class Solution {
  public String rightShift(String input, int n) {
    if (input == null || input.length() == 0 || n == 0) return input;
    char[] array = input.toCharArray();
    n %= input.length();
    reverse(array, 0, array.length - n - 1);
    reverse(array, array.length - n, array.length - 1);
    reverse(array, 0, array.length - 1);
    return new String(array);
  }
  private void reverse(char[] array, int i1, int i2) {
    while (i1 < i2) {
      char temp = array[i1];
      array[i1] = array[i2];
      array[i2] = temp;
    }
  }
}
