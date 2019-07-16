/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.

Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
*/

public class Solution {
  public List<String> subSets(String set) {
    List<String> result = new LinkedList<>();
    if (set == null) return result;
    dfs(set.toCharArray(), 0, new StringBuilder(), result);
    return result;
  }
  private void dfs(char[] array, int index, StringBuilder sb, List<String> list) {
    if (index == array.length) {
      list.add(sb.toString());
      return;
    }
    sb.append(array[index]);
    dfs(array, index + 1, sb, list);
    sb.deleteCharAt(sb.length() - 1);
    dfs(array, index + 1, sb, list);
  }
}
