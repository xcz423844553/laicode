/*
Given a string with no duplicate characters, return a list with all permutations of the characters.

Assume that input string is not null.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

Set = "", all permutations are [""]
*/

public class Solution {
  public List<String> permutations(String set) {
    List<String> result = new LinkedList<>();
    if (set == null) return result;
    dfs(set.toCharArray(), 0, result);
    return result;
  }
  private void dfs(char[] array, int index, List<String> list) {
    if (index == array.length) {
      list.add(new String(array));
      return;
    }
    for (int i = index; i < array.length; i++) {
      swap(array, index, i);
      dfs(array, index + 1, list);
      swap(array, index, i);
    }
  }
  private void swap(char[] array, int i1, int i2) {
    char temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }
}
