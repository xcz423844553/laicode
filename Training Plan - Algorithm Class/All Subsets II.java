/*
Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

There could be duplicate characters in the original set.

Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
*/

public class Solution {
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<>();
    if (set == null) return result;
    char[] c = set.toCharArray();
    Arrays.sort(c);
    subSets(c, 0, new StringBuilder(), result);
    return result;
  }
  private void subSets(char[] c, int index, StringBuilder sb, List<String> result) {
    if (index >= c.length) {
      result.add(sb.toString());
      return;
    }
    Set<Character> set = new HashSet<>();
    for (int i = index; i < c.length; i++) {
      if (!set.contains(c[i])) {
        set.add(c[i]);
        sb.append(c[i]);
        subSets(c, i + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
    subSets(c, c.length, sb, result);
  }
}
