/*
Given an array of elements, reorder it as follow:

{ N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

{ N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

Try to do it in place.

Assumptions

The given array is not null

Examples

{ 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }

{ 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }

{ 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
*/

public class Solution {
  public int[] reorder(int[] array) {
    if (array == null || array.length == 0) return array;
    reorder(array, 0, array.length % 2 == 0 ? array.length - 1 : array.length - 2);
    return array;
  }
  private void reorder(int[] array, int left, int right) {
    if (left >= right - 1) return;
    int mid = right - (right - left) / 2;
    int lenLeft = (right - left + 1) / 2 / 2;
    reverse(array, left + lenLeft, mid - 1);
    reverse(array, mid, mid + lenLeft - 1);
    reverse(array, left + lenLeft, mid + lenLeft - 1);
    reorder(array, left, left + 2 * lenLeft - 1);
    reorder(array, left + 2 * lenLeft, right);
  }
  private void reverse(int[] array, int start, int end) {
    while (start < end) {
      int temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      start++;
      end--;
    }
  }
}
