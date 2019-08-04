/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.

Assumptions

There could be duplicate characters in the original set.

Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "abb", K = 2, all the subsets are [“ab”, “bb”].

Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].

Set = null, K = 0, all the subsets are [].
*/

public class Solution {
  public List<String> subSetsIIOfSizeK(String set, int k) {
    List<String> result = new ArrayList<>();
    if (set == null) return result;
    char[] c = set.toCharArray();
    Arrays.sort(c);
    subSetsIIOfSizeK(c, 0, k, new StringBuilder(), result);
    return result;
  }
  private void subSetsIIOfSizeK(char[] c, int index, int k, StringBuilder sb, List<String> result) {
    if (k == 0) {
      result.add(sb.toString());
      return;
    }
    if (c.length - index < k) return;
    Set<Character> set = new HashSet<>();
    for (int i = index; i < c.length; i++) {
      if (!set.contains(c[i])) {
        set.add(c[i]);
        sb.append(c[i]);
        subSetsIIOfSizeK(c, i + 1, k - 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
