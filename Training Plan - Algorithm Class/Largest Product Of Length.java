/*
Given a dictionary containing many words, find the largest product of two words’ lengths, such that the two words do not share any common characters.

Assumptions

The words only contains characters of 'a' to 'z'
The dictionary is not null and does not contains null string, and has at least two strings
If there is no such pair of words, just return 0

Examples

dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
*/

public class Solution {
  public int largestProduct(String[] dict) {
    Map<String, Integer> map = getBitMask(dict);
    int max = 0;
    for (int i = 0; i < dict.length; i++) {
      for (int j = i + 1; j < dict.length; j++) {
        if ((map.get(dict[i]) & map.get(dict[j])) == 0) {
          max = Math.max(dict[i].length() * dict[j].length(), max);
        }
      }
    }
    return max;
  }
  private Map<String, Integer> getBitMask(String[] dict) {
    Map<String, Integer> map = new HashMap<>();
    for (String s : dict) {
      int mask = 0;
      for (int i = 0; i < s.length(); i++) {
        mask |= 1 << (s.charAt(i) - 'a');
      }
      map.put(s, mask);
    }
    return map;
  }
}
