/*
Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
*/

public class Solution {
  public int longest(String input) {
    if (input == null || input.length() == 0) return 0;
    int left = 0;
    int right = 0;
    int number = 0;
    int max = 0;
    while (right < input.length()) {
      char c = input.charAt(right);
      if ((number | getMask(c)) == number) {
        number ^= getMask(input.charAt(left));
        left++;
      } else {
        number |= getMask(c);
        right++;
        max = Math.max(max, right - left);
      }
    }
    return max;
  }
  private int getMask(char c) {
    return 1 << (c - 'a');
  }
}
