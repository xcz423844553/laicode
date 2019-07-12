/*
Given an array of integers, sort the elements in the array in ascending order.
The merge sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases

What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
*/

public class Solution {
  public int[] mergeSort(int[] array) {
    if (array == null || array.length == 0) return array;
    mergeSort(array, new int[array.length], 0, array.length - 1);
    return array;
  }
  private void mergeSort(int[] array, int[] helper, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    combine(array, helper, left, mid, right);
    return;
  }
  private void combine(int[] array, int[] helper, int left, int mid, int right) {
    int idxLeft = left;
    int idxRight = mid + 1;
    int idxHelper = left;
    while (idxLeft <= mid && idxRight <= right) {
      if (array[idxLeft] >= array[idxRight]) {
        helper[idxHelper++] = array[idxRight++];
      } else {
        helper[idxHelper++] = array[idxLeft++];
      }
    }
    while (idxLeft <= mid) {
      helper[idxHelper++] = array[idxLeft++];
    }
    while (idxRight <= right) {
      helper[idxHelper++] = array[idxRight++];
    }
    for (int i = left; i <= right; i++) {
      array[i] = helper[i];
    }
    return;
  }
}
```
