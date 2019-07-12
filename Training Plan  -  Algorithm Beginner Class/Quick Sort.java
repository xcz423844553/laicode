/*
Given an array of integers, sort the elements in the array in ascending order. 
The quick sort algorithm should be used to solve this problem.

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
  public int[] quickSort(int[] array) {
    if (array == null || array.length == 0) return array;
    quickSort(array, 0, array.length - 1);
    return array;
  }
  private void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivotIndex = left + new Random().nextInt(right - left + 1);
    int pivotValue = array[pivotIndex];
    swap(array, pivotIndex, right);
    int idxLeft = left;
    int idxRight = right - 1;
    while (idxLeft <= idxRight) {
      if (array[idxLeft] <= pivotValue) {
        idxLeft++;
      } else {
        swap(array, idxLeft, idxRight--);
      }
    }
    swap(array, idxLeft, right);
    quickSort(array, left, idxLeft - 1);
    quickSort(array, idxLeft + 1, right);
    return;
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
    return;
  }
}
