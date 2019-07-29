/*
Rotate an N * N matrix clockwise 90 degrees.

Assumptions

The matrix is not null and N >= 0

Examples

{ {1,  2,  3}
  {8,  9,  4},
  {7,  6,  5} }

after rotation is
{ {7,  8,  1}
  {6,  9,  2},
  {5,  4,  3} }
*/

public class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i <= (n - 1) / 2; i++) {
      rotate(matrix, i, n - 1 - 2 * i);
    }
    return;
  }
  private void rotate(int[][] matrix, int x, int side) {
    for (int i = 0; i < side; i++) {
      int temp = matrix[x][x + i];
      matrix[x][x + i] = matrix[x + side - i][x];
      matrix[x + side - i][x] = matrix[x + side][x + side - i];
      matrix[x + side][x + side - i] = matrix[x + i][x + side];
      matrix[x + i][x + side] = temp;
    }
  }
}
