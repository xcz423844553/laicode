/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

Assumptions

There are no duplicate characters in the original set.

Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].
*/

public class Solution {
  public List<String> subSetsOfSizeK(String set, int k) {
    List<String> result = new ArrayList<>();
    if (set == null) return result;
    subSetsOfSizeK(set.toCharArray(), 0, k, new StringBuilder(), result);
    return result;
  }
  private void subSetsOfSizeK(char[] c, int index, int k, StringBuilder sb, List<String> result) {
    if (k == 0) {
      result.add(sb.toString());
      return;
    }
    if (index >= c.length || c.length - index < k) return;
    subSetsOfSizeK(c, index + 1, k, sb, result);
    sb.append(c[index]);
    subSetsOfSizeK(c, index + 1, k - 1, sb, result);
    sb.deleteCharAt(sb.length() - 1);
  }
}
