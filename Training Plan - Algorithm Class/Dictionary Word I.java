/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty

Examples

Dictionary: {“bob”, “cat”, “rob”}

Word: “robob” return false

Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
*/

public class Solution {
  public boolean canBreak(String input, String[] dict) {
    boolean[] m = new boolean[input.length()];
    Set<String> set = new HashSet<>();
    for (String s : dict) {
      set.add(s);
    }
    for (int i = 0; i < input.length(); i++) {
      m[i] = set.contains(input.substring(0, i + 1));
      for (int j = i - 1; j >= 0 && !m[i]; j--) {
        if (set.contains(input.substring(j + 1, i + 1)) && m[j]) {
          m[i] = true;
        }
      }
    }
    return m[input.length() - 1];
  }
}
