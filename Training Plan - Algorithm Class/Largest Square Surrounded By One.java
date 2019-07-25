/*
Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0

Examples

{{1, 0, 1, 1, 1},
 {1, 1, 1, 1, 1},
 {1, 1, 0, 1, 0},
 {1, 1, 1, 1, 1},
 {1, 1, 1, 0, 0}}

The largest square surrounded by 1s has length of 3.
*/

public class Solution {
  public int largestSquareSurroundedByOne(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] left = new int[row][col];
    int[][] up = new int[row][col];
    int max = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0) {
          up[i][j] = matrix[i][j];
        } else {
          up[i][j] = matrix[i][j] == 0 ? 0 : up[i - 1][j] + 1;
        }
        if (j == 0) {
          left[i][j] = matrix[i][j];
        } else {
          left[i][j] = matrix[i][j] == 0 ? 0 : left[i][j - 1] + 1;
        }
        int len = Math.min(up[i][j], left[i][j]);
        for (int k = len; k > 0; k--) {
          if (left[i - k + 1][j] >= k && up[i][j - k + 1] >= k) {
            max = Math.max(max, k);
            break;
          }
        }
      }
    }
    return max;
  }
}
