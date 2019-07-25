/*
Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest cross.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

Examples

{ {0, 0, 0, 0},
  {1, 1, 1, 1},
  {0, 1, 1, 1},
  {1, 0, 1, 1} }

the largest cross of 1s has arm length 2.
*/

public class Solution {
  public int largest(int[][] matrix) {
    int[][] up = new int[matrix.length][matrix[0].length];
    int[][] down = new int[matrix.length][matrix[0].length];
    int[][] left = new int[matrix.length][matrix[0].length];
    int[][] right = new int[matrix.length][matrix[0].length];
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
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
      }
    }
    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = matrix[0].length - 1; j >= 0; j--) {
        if (i == matrix.length - 1) {
          down[i][j] = matrix[i][j];
        } else {
          down[i][j] = matrix[i][j] == 0 ? 0 : down[i + 1][j] + 1;
        }
        if (j == matrix[0].length - 1) {
          right[i][j] = matrix[i][j];
        } else {
          right[i][j] = matrix[i][j] == 0 ? 0 : right[i][j + 1] + 1;
        }
        int min = Math.min(up[i][j], left[i][j]);
        min = Math.min(min, down[i][j]);
        min = Math.min(min, right[i][j]);
        max = Math.max(max, min);
      }
    }
    return max;
  }
}
