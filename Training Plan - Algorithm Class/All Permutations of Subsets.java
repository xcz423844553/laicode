/*
Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.

Examples

Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].

Set = “”, all permutations are [“”].

Set = null, all permutations are [].
*/

public class Solution {
  public List<String> allPermutationsOfSubsets(String set) {
    List<String> result = new ArrayList<>();
    if (set == null) return result;
    allPermutationsOfSubsets(set.toCharArray(), 0, result);
    return result;
  }
  private void allPermutationsOfSubsets(char[] c, int index, List<String> result) {
    result.add(new String(c, 0, index));
    if (index >= c.length) return;
    for (int i = index; i < c.length; i++) {
      swap(c, index, i);
      allPermutationsOfSubsets(c, index + 1, result);
      swap(c, index, i);
    }
  }
  private void swap(char[] c, int i1, int i2) {
    char temp = c[i1];
    c[i1] = c[i2];
    c[i2] = temp;
  }
}
