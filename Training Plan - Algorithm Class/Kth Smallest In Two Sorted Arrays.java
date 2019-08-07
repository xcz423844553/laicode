/*
Given two sorted arrays of integers, find the Kth smallest number.

Assumptions

The two given arrays are not null and at least one of them is not empty

K >= 1, K <= total lengths of the two sorted arrays

Examples

A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.

A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
*/

public class Solution {
  public int kth(int[] a, int[] b, int k) {
    return kth(a, b, 0, 0, k);
  }
  private int kth(int[] a, int[] b, int aLeft, int bLeft, int k) {
    if (aLeft >= a.length) return b[bLeft + k - 1];
    if (bLeft >= b.length) return a[aLeft + k - 1];
    if (k == 1) return a[aLeft] > b[bLeft] ? b[bLeft] : a[aLeft];
    int aHalf = aLeft + k / 2 - 1 < a.length ? aLeft + k / 2 - 1 : a.length - 1;
    int bHalf = bLeft + k / 2 - 1 < b.length ? bLeft + k / 2 - 1 : b.length - 1;
    if (a[aHalf] >= b[bHalf]) {
      return kth(a, b, aLeft, bHalf + 1, k - (bHalf - bLeft + 1));
    } else {
      return kth(a, b, aHalf + 1, bLeft, k - (aHalf - aLeft + 1));
    }
  }
}
