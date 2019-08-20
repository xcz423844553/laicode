/*
Given an unsorted array of doubles, find the subarray that has the greatest product. Return the product.

Assumptions

The given array is not null and has length of at least 1.

Examples

{2.0, -0.1, 4, -2, -1.5}, the largest subarray product is 4 * (-2) * (-1.5) = 12
*/

public class Solution {
  public double largestProduct(double[] array) {
    double[] maxPos = new double[array.length];
    double[] minNeg = new double[array.length];
    maxPos[0] = array[0];
    minNeg[0] = array[0];
    double max = Math.max(maxPos[0], minNeg[0]);
    for (int i = 1; i < array.length; i++) {
      if (array[i] >= 0) {
        maxPos[i] = Math.max(array[i], maxPos[i - 1] * array[i]);
        minNeg[i] = Math.min(array[i], minNeg[i - 1] * array[i]);
      } else {
        maxPos[i] = Math.max(array[i], minNeg[i - 1] * array[i]);
        minNeg[i] = Math.min(array[i], maxPos[i - 1] * array[i]);
      }
      max = Math.max(max, maxPos[i]);
    }
    return max;
  }
}
