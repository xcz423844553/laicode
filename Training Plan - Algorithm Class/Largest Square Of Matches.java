/*
Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0

Examples

{{3, 1, 1, 3, 0, 1, 1, 0},
 {2, 0, 0, 2, 0, 0, 0, 0},
 {3, 1, 3, 0, 0, 0, 0, 0},
 {2, 0, 2, 0, 0, 0, 0, 0},
 {1, 1, 0, 0, 0, 0, 0, 0}}

This matrix represents the following bunch of matches:

The largest square has length of 2.
*/

public class Solution {
  public int largestSquareOfMatches(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] down = new int[row][col];
    int[][] right = new int[row][col];
    int max = 0;
    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 0; j--) {
        if (i == row - 1) {
          down[i][j] = 0;
        } else {
          down[i][j] = (matrix[i][j] == 2 || matrix[i][j] == 3) ? down[i + 1][j] + 1 : 0;
        }
        if (j == col - 1) {
          right[i][j] = 0;
        } else {
          right[i][j] = (matrix[i][j] == 1 || matrix[i][j] == 3) ? right[i][j + 1] + 1 : 0;
        }
        int len = Math.min(down[i][j], right[i][j]);
        for (int k = len; k > 0; k--) {
          if (right[i + k][j] >= k && down[i][j + k] >= k) {
            max = Math.max(max, k);
          }
        }
      }
    }
    return max;
  }
}
