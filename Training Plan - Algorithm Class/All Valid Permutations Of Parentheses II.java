/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0

Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
*/

public class Solution {
  public List<String> validParentheses(int l, int m, int n) {
    List<String> result = new ArrayList<>();
    validParentheses(l, l, m, m, n, n, new ArrayDeque<Character>(), new StringBuilder(), result);
    return result;
  }
  private void validParentheses(int lLeft, int lRight, int mLeft, int mRight, int nLeft, int nRight, Deque<Character> stack, StringBuilder sb, List<String> result) {
    if (lLeft == 0 && lRight == 0 && mLeft == 0 && mRight == 0 && nLeft == 0 && nRight == 0) {
      result.add(sb.toString());
      return;
    }
    if (lLeft > 0) {
      stack.offerFirst('(');
      sb.append('(');
      validParentheses(lLeft - 1, lRight, mLeft, mRight, nLeft, nRight, stack, sb, result);
      sb.deleteCharAt(sb.length() - 1);
      stack.pollFirst();
    }
    if (mLeft > 0) {
      stack.offerFirst('<');
      sb.append('<');
      validParentheses(lLeft, lRight, mLeft - 1, mRight, nLeft, nRight, stack, sb, result);
      sb.deleteCharAt(sb.length() - 1);
      stack.pollFirst();
    }
    if (nLeft > 0) {
      stack.offerFirst('{');
      sb.append('{');
      validParentheses(lLeft, lRight, mLeft, mRight, nLeft - 1, nRight, stack, sb, result);
      sb.deleteCharAt(sb.length() - 1);
      stack.pollFirst();
    }
    if (lRight > lLeft && stack.peekFirst() == '(') {
      stack.pollFirst();
      sb.append(')');
      validParentheses(lLeft, lRight - 1, mLeft, mRight, nLeft, nRight, stack, sb, result);
      sb.deleteCharAt(sb.length() - 1);
      stack.offerFirst('(');
    }
    if (mRight > mLeft && stack.peekFirst() == '<') {
      stack.pollFirst();
      sb.append('>');
      validParentheses(lLeft, lRight, mLeft, mRight - 1, nLeft, nRight, stack, sb, result);
      sb.deleteCharAt(sb.length() - 1);
      stack.offerFirst('<');
    }
    if (nRight > nLeft && stack.peekFirst() == '{') {
      stack.pollFirst();
      sb.append('}');
      validParentheses(lLeft, lRight, mLeft, mRight, nLeft, nRight - 1, stack, sb, result);
      sb.deleteCharAt(sb.length() - 1);
      stack.offerFirst('{');
    }
  }
}
