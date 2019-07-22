/*
Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.

Assumptions

s is not null or empty.
l is not null.

Examples

l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
*/

public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    List<Integer> list = new ArrayList<>();
    if (sh.length() == 0 || sh.length() > lo.length()) return list;
    int match = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < sh.length(); i++) {
      char c = sh.charAt(i);
      Integer count = map.get(c);
      if (count == null) {
        map.put(c, 1);
      } else {
        map.put(c, count + 1);
      }
    }
    for (int i = 0; i < lo.length(); i++) {
      char cNew = lo.charAt(i);
      Integer countNew = map.get(cNew);
      if (countNew != null) {
        map.put(cNew, countNew - 1);
        if (countNew == 1) match++;
      }
      if (i - sh.length() >= 0) {
        char cPrev = lo.charAt(i - sh.length());
        Integer countPrev = map.get(cPrev);
        if (countPrev != null) {
          map.put(cPrev, countPrev + 1);
          if (countPrev == 0) match--;
        }
      }
      if (match == map.size()) {
        list.add(i - sh.length() + 1);
      }
    }
    return list;
  }
}
