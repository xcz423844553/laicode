/*
Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

Assumptions

A is not null
K is >= 0 and smaller than or equal to size of A

Return

an array with size K containing the K smallest numbers in ascending order

Examples

A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
*/

public class Solution {
  public int[] kSmallest(int[] array, int k) {
    int[] result = new int[k];
    if (array == null || array.length == 0 || k == 0) return result;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
    for (int i = 0; i < array.length; i++) {
      if (i < k) {
        maxHeap.offer(array[i]);
      } else if (array[i] < maxHeap.peek()){
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    for (int i = k - 1; i >= 0; i--) {
      result[i] = maxHeap.poll();
    }
    return result;
  }
}

/*
Time = O(nlogk + klogk)
Space = O(k)
*/
