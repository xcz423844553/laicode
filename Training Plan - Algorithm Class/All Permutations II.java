/*
Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []
*/

public class Solution {
  public List<String> permutations(String set) {
    List<String> result = new ArrayList<>();
    dfs(set.toCharArray(), 0, result);
    return result;
  }
  private void dfs(char[] array, int index, List<String> list) {
    if (index == array.length) {
      list.add(new String(array));
      return;
    }
    Set<Character> usedChar = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      if (!usedChar.contains(array[i])) {
        usedChar.add(array[i]);
        swap(array, i, index);
        dfs(array, index + 1, list);
        swap(array, i, index);
      }
    }
  }
  private void swap(char[] array, int i1, int i2) {
    char temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }
}
