/*
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Assumptions

N > 0

Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
*/

public class Solution {
  public List<String> validParentheses(int n) {
    List<String> result = new LinkedList<>();
    dfs(n, n, new StringBuilder(), result);
    return result;
  }
  private void dfs(int nLeft, int nRight, StringBuilder sb, List<String> list) {
    if (nLeft == 0 && nRight == 0) {
      list.add(sb.toString());
      return;
    }
    if (nLeft > 0) {
      sb.append('(');
      dfs(nLeft - 1, nRight, sb, list);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (nRight > nLeft) {
      sb.append(')');
      dfs(nLeft, nRight - 1, sb, list);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
