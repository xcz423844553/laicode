/*
Given a matrix that contains integers, find the submatrix with the largest sum.

Return the sum of the submatrix.

Assumptions

The given matrix is not null and has size of M * N, where M >= 1 and N >= 1

Examples

{ {1, -2, -1, 4},
  {1, -1,  1, 1},
  {0, -1, -1, 1},
  {0,  0,  1, 1} }

the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
*/

public class Solution {
  public int largest(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] sumMatrix = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0) {
          sumMatrix[i][j] = matrix[i][j];
        } else {
          sumMatrix[i][j] = sumMatrix[i - 1][j] + matrix[i][j];
        }
      }
    }
    int maxSum = matrix[0][0];
    for (int up = 0; up < row; up++) {
      for (int bot = up; bot < row; bot++) {
        int sum = sumMatrix[bot][0] - sumMatrix[up][0] + matrix[up][0];
        for (int k = 1; k < col; k++) {
          if (sum <= 0) {
            sum = sumMatrix[bot][k] - sumMatrix[up][k] + matrix[up][k];
          } else {
            sum += sumMatrix[bot][k] - sumMatrix[up][k] + matrix[up][k];
          }
          maxSum = Math.max(maxSum, sum);
        }
      }
    }
    return maxSum;
  }
}
