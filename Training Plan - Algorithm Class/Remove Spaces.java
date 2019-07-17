/*
Given a string, remove all leading/trailing/duplicated empty spaces.

Assumptions:

The given string is not null.

Examples:

“  a” --> “a”
“   I     love MTV ” --> “I love MTV”
*/

public class Solution {
  public String removeSpaces(String input) {
    if (input == null || input.length() == 0) return input;
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < input.length(); fast++) {
      if (array[fast] == ' ' && (slow == 0 || array[slow - 1] == ' ')) {
        continue;
      }
      array[slow++] = array[fast];
    }
    if (slow != 0 && array[slow - 1] == ' ') {
      slow--;
    }
    return new String(array, 0, slow);
  }
}
