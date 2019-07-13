/*
Enhance the stack implementation to support min() operation.
min() should return the current minimum value in the stack. 
If the stack is empty, min() should return -1.

pop() - remove and return the top element, if the stack is empty, return -1
push(int element) - push the element to top
pop() - return the top element and remove it, if the stack is empty, return -1
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.
*/

public class Solution {
  Deque<Integer> stack;
  Deque<Integer> minStack;
  public Solution() {
    stack = new LinkedList<>();
    minStack = new LinkedList<>();
  }
  
  public int pop() {
    if (stack.isEmpty()) return -1;
    minStack.pollLast();
    return stack.pollLast();
  }
  
  public void push(int element) {
    int min = element;
    if (!minStack.isEmpty()) {
      min = Math.min(element, minStack.peekLast());
    }
    stack.offerLast(element);
    minStack.offerLast(min);
  }
  
  public int top() {
    if (stack.isEmpty()) return -1;
    return stack.peekLast();
  }
  
  public int min() {
    if (stack.isEmpty()) return -1;
    return minStack.peekLast();
  }
}
