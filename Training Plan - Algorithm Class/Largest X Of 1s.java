/*
Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest X shape.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

Examples

{ {0, 0, 0, 0},
  {1, 1, 1, 1},
  {0, 1, 1, 1},
  {1, 0, 1, 1} }

the largest X of 1s has arm length 2.
*/

public class Solution {
  public int largest(int[][] matrix) {
    int[][] leftUp = new int[matrix.length][matrix[0].length];
    int[][] rightUp = new int[matrix.length][matrix[0].length];
    int[][] leftDown = new int[matrix.length][matrix[0].length];
    int[][] rightDown = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == 0 || j == 0) {
          leftUp[i][j] = matrix[i][j];
        } else {
          leftUp[i][j] = matrix[i][j] == 0 ? 0 : leftUp[i - 1][j - 1] + 1;
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == 0 || j == matrix[0].length - 1) {
          rightUp[i][j] = matrix[i][j];
        } else {
          rightUp[i][j] = matrix[i][j] == 0 ? 0 : rightUp[i - 1][j + 1] + 1;
        }
      }
    }
    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == matrix.length - 1 || j == 0) {
          leftDown[i][j] = matrix[i][j];
        } else {
          leftDown[i][j] = matrix[i][j] == 0 ? 0 : leftDown[i + 1][j - 1] + 1;
        }
      }
    }
    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == matrix.length - 1 || j == matrix[0].length - 1) {
          rightDown[i][j] = matrix[i][j];
        } else {
          rightDown[i][j] = matrix[i][j] == 0 ? 0 : rightDown[i + 1][j + 1] + 1;
        }
      }
    }
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int min = Math.min(leftUp[i][j], rightUp[i][j]);
        min = Math.min(leftDown[i][j], min);
        min = Math.min(rightDown[i][j], min);
        max = Math.max(max, min);
      }
    }
    return max;
  }
}
