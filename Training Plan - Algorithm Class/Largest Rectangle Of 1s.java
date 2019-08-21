/*
Determine the largest rectangle of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the area.

Assumptions

The given matrix is not null and has size of M * N, M >= 0 and N >= 0

Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest rectangle of 1s has area of 2 * 3 = 6
*/

public class Solution {
  public int largest(int[][] matrix) {
    int[][] len = new int[matrix.length][matrix[0].length];
    for (int row = 0; row < matrix.length; row++) {
      int left = 0;
      for (int col = 0; col < matrix[0].length; col++) {
        if (matrix[row][col] == 0) {
          left = 0;
        } else {
          left++;
        }
        len[row][col] = left;
      }
    }
    int area = 0;
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        int w = len[row][col];
        int h = 0;
        for (int r = row; r >= 0; r--) {
          w = Math.min(w, len[r][col]);
          h = row - r + 1;
          area = Math.max(area, w * h);
        }
      }
    }
    return area;
  }
}
