/*
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

Assumptions

A is not null
K is guranteed to be >= 0 and K is guranteed to be <= A.length

Return

A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T. 

Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
*/

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if (array == null || array.length == 0 || k == 0) return new int[0]; 
    int smallEqualIndex = findSmallerEqual(array, target);
    int[] result = new int[k];
    int left = smallEqualIndex, right = smallEqualIndex + 1;
    for (int i = 0; i < k; i++) {
      if (right > array.length - 1 || left >= 0 && array[right] - target > target - array[left]) {
        result[i] = array[left--];
      } else {
        result[i] = array[right++];
      }
    }
    return result;
  }
  
  //return the index of the element closest to target
  private int findSmallerEqual(int[] array, int target) {
    int left = 0, right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] > target) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return array[right] <= target ? right : (array[left] <= target ? left :-1);
  }
}
