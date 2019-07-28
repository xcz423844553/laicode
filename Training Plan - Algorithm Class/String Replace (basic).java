/*
Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Assumptions

input, S and T are not null, S is not empty string

Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "laicode", S = "code", T = "offer", input becomes "laioffer"
*/

public class Solution {
  public String replace(String input, String source, String target) {
    char[] array = input.toCharArray();
    if (target.length() > source.length()) {
      return new String(replaceLong(array, source, target));
    } else {
      return replaceShort(array, source, target);
    }
  }
  private char[] replaceLong(char[] array, String source, String target) {
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      if (isSubstring(array, i, source)) {
        count++;
        i += source.length() - 1;
      } 
    }
    char[] newArray = new char[array.length + count * (target.length() - source.length())];
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++){
      if (isSubstring(array, fast, source)) {
        replaceSubstring(newArray, slow, target);
        slow += target.length();
        fast += source.length() - 1;
      } else {
        newArray[slow++] = array[fast];
      } 
    }
    return newArray;
  }
  private String replaceShort(char[] array, String source, String target) {
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (isSubstring(array, fast, source)) {
        replaceSubstring(array, slow, target);
        fast += source.length() - 1;
        slow += target.length();
      } else {
        array[slow++] = array[fast];
      }
    }
    return new String(array, 0, slow);
  }
  private boolean isSubstring(char[] array, int index, String source) {
    for (int i = 0; i < source.length(); i++) {
      if (index + i >= array.length || array[index + i] != source.charAt(i)) {
        return false;
      }
    }
    return true;
  }
  private void replaceSubstring(char[] array, int index, String target) {
    for (int i = 0; i < target.length(); i++) {
      array[index + i] = target.charAt(i);
    }
    return;
  }
}

