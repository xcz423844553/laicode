/*
Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Assumptions

input, S and T are not null, S is not empty string

Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "dodododo", S = "dod", T = "a", input becomes "aoao"
*/

public class Solution {
  public String replace(String input, String source, String target) {
    if (source.length() >= target.length()) {
      return replaceShort(input.toCharArray(), source, target);
    } else {
      return replaceLong(input.toCharArray(), source, target);
    }
  }
  private String replaceShort(char[] array, String source, String target) {
    int slow = 0;
    for (int i = 0; i < array.length; i++) {
      if (isSubstring(array, i, source)) {
        for (int j = 0; j < target.length(); j++) {
          array[slow++] = target.charAt(j);
        }
        i += source.length() - 1;
      } else {
        array[slow++] = array[i];
      }
    }
    return new String(array, 0, slow);
  }
  private String replaceLong(char[] array, String source, String target) {
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      if (isSubstring(array, i, source)) {
        count++;
        i += source.length() - 1;
      }
    }
    char[] result = new char[array.length - count * source.length() + count * target.length()];
    int slow = 0;
    for (int i = 0; i < array.length; i++) {
      if (isSubstring(array, i, source)) {
        for (int j = 0; j < target.length(); j++) {
          result[slow++] = target.charAt(j);
        }
        i += source.length() - 1;
      } else {
        result[slow++] = array[i];
      }
    }
    return new String(result);
  }
  private boolean isSubstring(char[] array, int start, String source) {
    if (start + source.length() - 1 >= array.length) return false;
    for (int i = 0; i < source.length(); i++) {
      if (array[start + i] != source.charAt(i)) return false;
    }
    return true;
  }
}
