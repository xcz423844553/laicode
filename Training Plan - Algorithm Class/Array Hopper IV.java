/*
Given an array A of non-negative integers, you are initially positioned at an arbitrary index of the array. A[i] means the maximum jump distance from that position (you can either jump left or jump right). Determine the minimum jumps you need to reach the right end of the array. Return -1 if you can not reach the right end of the array.

Assumptions

The given array is not null and has length of at least 1.

Examples

{1, 3, 1, 2, 2}, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array)

{3, 3, 1, 0, 0}, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array)

{4, 0, 1, 0, 0}, if the initial position is 2, you are not able to reach the right end of array, return -1 in this case.
*/

public class Solution {
  public int minJump(int[] array, int index) {
    if (array == null || array.length == 0) return 0;
    if (index < 0 || index >= array.length) return -1;
    int step = 0;
    boolean[] visited = new boolean[array.length];
    visited[index] = true;
    Queue<Integer> q = new LinkedList<>();
    q.offer(index);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Integer idx = q.poll();
        if (idx == array.length - 1) return step;
        for (int j = idx - array[idx]; j <= idx + array[idx]; j++) {
          if (j >= 0 && j < array.length && !visited[j]) {
            q.offer(j);
            visited[j] = true;
          }
        }
      }
      step++;
    }
    return -1;
  }
}
