/*
Given two arrays of integers, find the median value.

Assumptions

The two given array are not null and at least one of them is not empty
The two given array are not guaranteed to be sorted

Examples

A = {4, 1, 6}, B = {2, 3}, median is 3
A = {1, 4}, B = {3, 2}, median is 2.5
*/

public class Solution {
  public double median(int[] a, int[] b) {
    PriorityQueue<Integer> left = new PriorityQueue<>(1, Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    for (int i = 0; i < a.length; i++) {
      addNumber(a[i], left, right);
    }
    for (int j = 0; j < b.length; j++) {
      addNumber(b[j], left, right);
    }
    return getMedian(left, right);
  }
  private double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
    return left.size() > right.size() ? (double)(left.peek()) : (left.peek() + right.peek()) / ((double)2.0);
  }
  private void addNumber(int num, PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
    if (left.isEmpty() || num <= left.peek()) {
      if (left.size() == right.size()) {
        left.offer(num);
      } else {
        left.offer(num);
        right.offer(left.poll());
      }
    } else {
      if (left.size() == right.size()) {
        right.offer(num);
        left.offer(right.poll());
      } else {
        right.offer(num);
      }
    }
  }
}
