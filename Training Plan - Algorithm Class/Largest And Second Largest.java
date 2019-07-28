/*
Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. Return the largest number and 2nd largest number.

Assumptions

The given array is not null and has length of at least 2

Examples

{2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
*/

public class Solution {
  public int[] largestAndSecond(int[] array) {
    Queue<Element> q = new LinkedList<>();
    for (int i : array) {
      q.offer(new Element(i));
    }
    while (q.size() > 1) {
      Element e1 = q.poll();
      Element e2 = q.poll();
      if (e1.value > e2.value) {
        e1.addSecondLargest(e2);
        q.offer(e1);
      } else {
        e2.addSecondLargest(e1);
        q.offer(e2);
      }
    }
    Element max = q.poll();
    return new int[]{max.value, max.secondLargest};
  }
  static class Element {
    public int value;
    public Integer secondLargest;
    public Element(int value) {
      this.value = value;
      this.secondLargest = null;
    }
    public void addSecondLargest(Element e) {
      if (e != null && (secondLargest == null || secondLargest < e.value)) {
        secondLargest = e.value;
      }
    }
  }
}
