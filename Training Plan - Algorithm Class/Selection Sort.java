/*
Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.

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
  public int[] solve(int[] array) {
    if (array == null || array.length == 0) return array;
    for (int i = 0; i < array.length; i++) {
      int indexMin = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[indexMin]) {
          indexMin = j;
        }
      }
      swap(array, i, indexMin);
    }
    return array;
  }
  private void swap(int[] array, int i1, int i2) {
    int temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }
}
