/*
Reverse a given string.

Assumptions

The given string is not null.
*/

public class Solution {
  public String reverse(String input) {
    if (input == null || input.length() == 0) return input;
    char[] array = input.toCharArray();
    int left = 0, right = array.length - 1;
    while (left < right) {
      swap(array, left++, right--);
    }
    return new String(array);
  }
  private void swap(char[] array, int i1, int i2) {
    char temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }
}
