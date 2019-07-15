/*
Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

pop() - remove and return the top element, if the stack is empty, return -1

push(int element) - push the element to top
pop() - return the top element and remove it, if the stack is empty, return -1
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.
*/

public class Solution {
  Deque<Integer> stack1;
  Deque<Integer> stack2;
  public Solution() {
    stack1 = new LinkedList<>();
    stack2 = new LinkedList<>();
  }
  
  public int pop() {
    if (stack1.isEmpty()) return -1;
    stack2.pollLast();
    return stack1.pollLast();
  }
  
  public void push(int element) {
    Integer lastMin = stack2.peekLast();
    stack1.offerLast(element);
    if (lastMin == null || element < lastMin) {
      stack2.offerLast(element);
    } else {
      stack2.offerLast(lastMin);
    }
  }
  
  public int top() {
    if (stack1.isEmpty()) return -1;
    return stack1.peekLast();
  }
  
  public int min() {
    if (stack1.isEmpty()) return -1;
    return stack2.peekLast();
  }
}
