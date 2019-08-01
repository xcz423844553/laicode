/*
Given an array A of length N containing all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].

Assumptions:

The given array A is not null.

Examples:

A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.

Requirement:

time complexity = O(nlogn).
*/

public class Solution {
  public int[] countArray(int[] array) {
    if (array.length == 0) return array;
    int[] indices = new int[array.length];
    int[] counter = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      indices[array[i] - 1] = i;
    }
    partition(array, new int[array.length], counter, indices, 0, array.length - 1);
    return counter;
  }
  public void partition(int[] array, int[] helper, int[] counter, int[] indices, int left, int right) {
    if (left >= right) return;
    int mid = left + (right - left) / 2;
    partition(array, helper, counter, indices, left, mid);
    partition(array, helper, counter, indices, mid + 1, right);
    merge(array, helper, counter, indices, left, mid, right);
  }
  public void merge(int[] array, int[] helper, int[] counter, int[] indices, int left, int mid, int right) {
    int idxLeft = left;
    int idxRight = mid + 1;
    int cur = left;
    while (idxLeft <= mid && idxRight <= right) {
      if (array[idxLeft] < array[idxRight]) {
        counter[indices[array[idxLeft] - 1]] += idxRight - (mid + 1);
        helper[cur++] = array[idxLeft++];
      } else {
        helper[cur++] = array[idxRight++];
      }
    }
    while (idxLeft <= mid) {
      counter[indices[array[idxLeft] - 1]] += right - (mid + 1) + 1;
      helper[cur++] = array[idxLeft++];
    }
    for (int i = left; i < cur; i++) {
      array[i] = helper[i];
    }
  }
}
