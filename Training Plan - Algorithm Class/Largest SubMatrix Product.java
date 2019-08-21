/*
Given a matrix that contains doubles, find the submatrix with the largest product.

Return the product of the submatrix.

Assumptions

The given double matrix is not null and has size of M * N, where M >= 1 and N >= 1

Examples

{ {1, -0.2, -1},
  {1, -1.5,  1},
  {0,     0,  1} }

the largest submatrix product is 1 * 1 = 1.
*/

public class Solution {
  public double largest(double[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    double largest = Integer.MIN_VALUE;
    for (int i = 0; i < row; i++) {
      double[] prod = new double[col];
      for (int k = 0; k < col; k++) {
        prod[k] = 1.0;
      }
      for (int j = i; j < row; j++) {
        for (int k = 0; k < col; k++) {
          prod[k] = prod[k] * matrix[j][k];
        }
        double max = prod[0];
        largest = Math.max(largest, max);
        double min = prod[0];
        for (int z = 1; z < col; z++) {
          double temp = max;
          max = Math.max(Math.max(max * prod[z], min * prod[z]), prod[z]);
          min = Math.min(Math.min(temp * prod[z], min * prod[z]), prod[z]);
          largest = Math.max(largest, max);
        }
      }
    }
    return largest;
  }
}

