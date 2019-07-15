/*
Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. When the queue is empty, poll() and peek() should return null.

C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), front() and pop() operations. When the queue is empty, front() should return -1.

Assumptions

The elements in the queue are all Integers.
size() should return the number of elements buffered in the queue.
isEmpty() should return true if there is no element buffered in the queue, false otherwise.
*/

public class Solution {
  Deque<Integer> stack1;
  Deque<Integer> stack2;
  public Solution() {
    stack1 = new LinkedList<>();
    stack2 = new LinkedList<>();
  }
  
  public Integer poll() {
    moveFromS1ToS2IfS2Empty();
    return stack2.pollLast();
  }
  
  public void offer(int element) {
    stack1.offerLast(element);
  }
  
  public Integer peek() {
    moveFromS1ToS2IfS2Empty();
    return stack2.peekLast();
  }
  
  public int size() {
    return stack1.size() + stack2.size();
  }
  
  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
  
  private void moveFromS1ToS2IfS2Empty() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.offerLast(stack1.pollLast());
      }
    }
  }
}
