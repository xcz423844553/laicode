/*
Given an unlimited flow of numbers, keep track of the median of all elements seen so far.

You will have to implement the following two methods for the class

read(int value) - read one value from the flow
median() - return the median at any time, return null if there is no value read so far

Examples

read(1), median is 1
read(2), median is 1.5
read(3), median is 2
read(10), median is 2.5
......
*/

public class Solution {
  private PriorityQueue<Integer> maxHeap;
  private PriorityQueue<Integer> minHeap;
  //maxHeap.size() is always >= minHeap.size()
  public Solution() {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }
  
  public void read(int value) {
    if (maxHeap.peek() == null || maxHeap.peek() >= value) {
      maxHeap.offer(value);
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      }
    } else {
      minHeap.offer(value);
      if (maxHeap.size() < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
    }
  }
  
  public Double median() {
    if (maxHeap.isEmpty() && minHeap.isEmpty()) {
      return null;
    } else if (maxHeap.size() == minHeap.size()) {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
    return (double)maxHeap.peek();
  }
}
