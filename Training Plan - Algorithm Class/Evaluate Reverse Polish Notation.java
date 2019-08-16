/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Assumption

Valid operators are +, -, *, /.
Each operand may be an integer or another expression.

Examples

["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) return 0;
    Deque<Integer> stack = new LinkedList<>();
    for (String s : tokens) {
      if (s.equals("+")) {
        stack.offerLast(stack.pollLast() + stack.pollLast());
      } else if (s.equals("-")) {
        stack.offerLast(stack.pollLast() - stack.pollLast());
      } else if (s.equals("*")) {
        stack.offerLast(stack.pollLast() * stack.pollLast());
      } else if (s.equals("/")) {
        stack.offerLast(stack.pollLast() / stack.pollLast());
      } else {
        stack.offerLast(getIntFromStr(s));
      }
    }
    return stack.pollLast();
  }
  private int getIntFromStr(String s) {
    int num = 0;
    for (int i = 0; i < s.length(); i++) {
      num = num * 10 + (s.charAt(i) - '0');
    }
    return num;
  }
}
