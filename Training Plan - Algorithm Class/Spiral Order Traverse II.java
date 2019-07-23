/*
Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions

The 2D array is not null and has size of M * N where M, N >= 0

Examples

{ {1,  2,  3,  4},
  {5,  6,  7,  8},
  {9, 10, 11, 12} }

the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
*/

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    List<Integer> list = new ArrayList<>();
    if (matrix == null || row == 0 || col == 0) return list;
    spiral(matrix, 0, col - 1, row - 1, list);
    return list;
  }
  private void spiral(int[][] matrix, int offset, int rowSpan, int colSpan, List<Integer> list) {
    if (rowSpan < 0 || colSpan < 0) return;
    if (rowSpan == 0 && colSpan == 0) {
      list.add(matrix[offset][offset]);
      return;
    }
    for (int i = offset; i < offset + rowSpan + (colSpan == 0 ? 1 : 0); i++) {
      list.add(matrix[offset][i]);
    }
    for (int i = offset; i < offset + colSpan + (rowSpan == 0 ? 1 : 0); i++) {
      list.add(matrix[i][offset + rowSpan]);
    }
    for (int i = offset + rowSpan; rowSpan > 0 && colSpan > 0 && i > offset; i--) {
      list.add(matrix[offset + colSpan][i]);
    }
    for (int i = offset + colSpan; rowSpan > 0 && colSpan > 0 && i > offset; i--) {
      list.add(matrix[i][offset]);
    }
    spiral(matrix, offset + 1, rowSpan - 2, colSpan - 2, list);
  }
}
