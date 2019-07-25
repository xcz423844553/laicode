/*
Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

Assumptions

The given matrix is not null and guaranteed to be of size N * N, N >= 0

Examples

{ {0, 0, 0, 0},
  {1, 1, 1, 1},
  {0, 1, 1, 1},
  {1, 0, 1, 1}}

the largest square of 1s has length of 2
*/

public class Solution {
  public int largest(int[][] matrix) {
    int[][] square = new int[matrix.length][matrix[0].length];
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0 || i == 0 || j == 0) {
          square[i][j] = matrix[i][j];
        } else {
          square[i][j] = Math.min(square[i][j - 1], square[i - 1][j]);
          square[i][j] = Math.min(square[i][j], square[i - 1][j - 1]);
          square[i][j]++;
        }
        max = Math.max(square[i][j], max);
      }
    }
    return max;
  }
}
