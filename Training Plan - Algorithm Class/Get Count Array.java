/*
Given an array A with all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].

Assumptions:

The given array A is not null.
Examples:

A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
Requirement:

time complexity = O(nlogn).
*/

public class Solution {
  public int[] countArray(int[] array) {
    int[] indices = new int[array.length];
    int[] counts = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      indices[i] = i;
    }
    mergeSort(array, indices, counts, new int[indices.length], 0, indices.length - 1);
    return counts;
  }
  private void mergeSort(int[] array, int[] indices, int[] counts, int[] helper, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, indices, counts, helper, left, mid);
    mergeSort(array, indices, counts, helper, mid + 1, right);
    combine(array, indices, counts, helper, left, mid, right);
    for (int i = left; i <= right; i++) {
      indices[i] = helper[i];
    }
  }
  private void combine(int[] array, int[] indices, int[] counts, int[] helper, int left, int mid, int right) {
    int curLeft = left;
    int curRight = mid + 1;
    int curHelper = left;
    while (curLeft <= mid && curRight <= right) {
      if (array[indices[curLeft]] > array[indices[curRight]]) {
        helper[curHelper++] = indices[curLeft];
        counts[indices[curLeft]] += right - curRight + 1;
        curLeft++;     
      } else if (array[indices[curLeft]] <= array[indices[curRight]]) {
        helper[curHelper++] = indices[curRight++];
      }
    }
    while (curLeft <= mid) {
      helper[curHelper++] = indices[curLeft++];
    }
    while (curRight <= right) {
      helper[curHelper++] = indices[curRight++];
    }
  }
}
