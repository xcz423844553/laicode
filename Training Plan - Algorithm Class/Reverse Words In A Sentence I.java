/*
Reverse the words in a sentence.

Assumptions

Words are separated by single space

There are no heading or tailing white spaces

Examples

“I love Google” → “Google love I”

Corner Cases

If the given string is null, we do not need to do anything.
*/

public class Solution {
  public String reverseWords(String input) {
    if (input == null || input.length() == 0) return input;
    int slow = 0;
    char[] array = input.toCharArray();
    for (int fast = 0; fast < array.length; fast++) {
      while (fast < array.length && array[fast] != ' ') {
        fast++;
      }
      reverse(array, slow, fast - 1);
      slow = fast + 1;
    }
    reverse(array, 0, array.length - 1);
    return new String(array);
  }
  private void reverse(char[] array, int i1, int i2) {
    while (i1 < i2) {
      char temp = array[i1];
      array[i1] = array[i2];
      array[i2] = temp;
      i1++;
      i2--;
    }
  }
}
