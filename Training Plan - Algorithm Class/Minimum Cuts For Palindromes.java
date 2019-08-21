/*
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.

Assumptions

The given string is not null

Examples

“a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.

The minimum number of cuts needed is 3.
*/

public class Solution {
  public int minCuts(String input) {
    if (input == null || input.length() == 0) return 0;
    int[] m = new int[input.length()];
    m[0] = 0;
    for (int i = 1; i < input.length(); i++) {
      m[i] = isPalindrome(input, 0, i) ? 0 : i;
      for (int j = 1; j <= i; j++) {
        m[i] = Math.min(m[i], m[j - 1] + (isPalindrome(input, j, i) ? 1 : i - j + 1));
      }
    }
    return m[input.length() - 1];
  }
  private boolean isPalindrome(String input, int i1, int i2) {
    while (i1 <= i2) {
      if (input.charAt(i1) != input.charAt(i2)) {
        return false;
      }
      i1++;
      i2--;
    }
    return true;
  }
}
