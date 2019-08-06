/*
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.

Assumptions

The given array is not null or empty

Examples

{ 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)
*/

public class Solution {
  public int largest(int[] array) {
    Deque<Integer> stack = new ArrayDeque<>();
    int max = 0;
    for (int i = 0; i <= array.length; i++) {
      int newNum = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && array[stack.peekLast()] > newNum) {
        int height = array[stack.pollLast()];
        int width = i - (stack.isEmpty() ? 0 : stack.peekLast() + 1);
        max = Math.max(max, width * height);
      }
      stack.offerLast(i);
    }
    return max;
  }
}

