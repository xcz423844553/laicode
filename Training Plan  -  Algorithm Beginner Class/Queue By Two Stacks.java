/%
Java: Implement a queue by using two stacks. 
The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. 
When the queue is empty, poll() and peek() should return null.

C++: Implement a queue by using two stacks.
The queue should provide size(), isEmpty(), push(), front() and pop() operations. 
When the queue is empty, front() should return -1.

Assumptions

The elements in the queue are all Integers.
size() should return the number of elements buffered in the queue.
isEmpty() should return true if there is no element buffered in the queue, false otherwise.
%/

public class Solution {
  Deque<Integer> in; // Stack to store the elements when it is offered
  Deque<Integer> out; // Stack to pop out the elements
  public Solution() {
    in = new LinkedList<>();
    out = new LinkedList<>();
  }
  
  public Integer poll() {
    moveElementFromInToOut();
    return out.pollLast();
  }
  
  public void offer(int element) {
    in.offer(element);
  }
  
  public Integer peek() {
    moveElementFromInToOut();
    return out.peekLast();
  }
  
  public int size() {
    return in.size() + out.size();
  }
  
  public boolean isEmpty() {
    return in.size() + out.size() == 0;
  }
  
  private void moveElementFromInToOut() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.offerLast(in.pollLast());
      }
    }
  }
}
