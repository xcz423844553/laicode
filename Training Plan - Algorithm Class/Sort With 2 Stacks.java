/*
Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).

After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

Assumptions:

The given stack is not null.
There can be duplicated numbers in the give stack.

Requirements:

No additional memory, time complexity = O(n ^ 2).
*/

public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    for (int i = s1.size(); i > 0; i--) {
      Integer min = null;
      for (int j = i; j > 0; j--) {
        Integer elem = s1.pollLast();
        if (min == null || elem < min) {
          Integer temp = min;
          min = elem;
          elem = temp;
        }
        if (elem != null) s2.offerLast(elem);
      }
      s1.offerLast(min);
      while (!s2.isEmpty()) {
        s1.offerLast(s2.pollLast());
      }
    }
  }
}
