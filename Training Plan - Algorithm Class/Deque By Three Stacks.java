/*
Java: Implement a deque by using three stacks. The queue should provide size(), isEmpty(), offerFirst(), offerLast(), pollFirst(), pollLast(), peekFirst() and peekLast() operations. When the queue is empty, pollFirst(), pollLast(), peekFirst() and peek() should return null.

Python: Implement a deque by using three stacks. The queue should provide size(), isEmpty(), offerFirst(), offerLast(), pollFirst(), pollLast(), peekFirst() and peekLast() operations. When the queue is empty, pollFirst(), pollLast(), peekFirst() and peek() should return None

C++: Implement a deque by using three stacks. The queue should provide size(), isEmpty(), push_front(), push_back(), pop_front(), pop_back(), front() and back() operations. When the queue is empty, front() and back() should return -1.

Assumptions

The elements in the queue are all Integers.

size() should return the number of elements buffered in the queue.

isEmpty() should return true if there is no element buffered in the queue, false otherwise.

The amortized time complexity of all operations should be O(1).
*/

public class Solution {
  Deque<Integer> firstStack;
  Deque<Integer> bufferStack;
  Deque<Integer> lastStack;
  public Solution() {
    firstStack = new ArrayDeque<>();
    bufferStack = new ArrayDeque<>();
    lastStack = new ArrayDeque<>();
  }
  
  public void offerFirst(int element) {
    firstStack.offerFirst(element);
  }
  
  public void offerLast(int element) {
    lastStack.offerFirst(element);
  }
  
  public Integer pollFirst() {
    if (firstStack.isEmpty()) rebalanceStack();
    return firstStack.pollFirst();
  }
  
  public Integer pollLast() {
    if (lastStack.isEmpty()) rebalanceStack();
    return lastStack.pollFirst();
  }
  
  public Integer peekFirst() {
    if (firstStack.isEmpty()) rebalanceStack();
    return firstStack.peekFirst();
  }
  
  public Integer peekLast() {
    if (lastStack.isEmpty()) rebalanceStack();
    return lastStack.peekFirst();
  }
  
  public int size() {
    return firstStack.size() + bufferStack.size() + lastStack.size();
  }
  
  public boolean isEmpty() {
    return this.size() == 0;
  }

  private void rebalanceStack() {
    Deque<Integer> emptyStack = firstStack.isEmpty() ? firstStack : lastStack;
    Deque<Integer> fullStack = firstStack.isEmpty() ? lastStack : firstStack;
    if (fullStack.size() == 1) {
      emptyStack.offerFirst(fullStack.pollFirst());
      return;
    }
    int bufferSize = fullStack.size() / 2;
    for (int i = 0; i < bufferSize; i++) {
      bufferStack.offerFirst(fullStack.pollFirst());
    }
    while (!fullStack.isEmpty()) {
      emptyStack.offerFirst(fullStack.pollFirst());
    }
    while (!bufferStack.isEmpty()) {
      fullStack.offerFirst(bufferStack.pollFirst());
    }
  }
}
