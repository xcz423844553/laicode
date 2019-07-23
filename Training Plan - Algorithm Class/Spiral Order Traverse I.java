/*
Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions

The 2D array is not null and has size of N * N where N >= 0

Examples

{ {1,  2,  3},
  {4,  5,  6},
  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
*/

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if (matrix.length == 0) return list;
    spiral(matrix, 0, matrix.length - 1, list);
    return list; 
  }
  private void spiral(int[][]matrix, int offset, int length, List<Integer> list) {
    if (length < 0) return;
    if (length == 0) {
      list.add(matrix[offset][offset]);
      return;
    }
    for (int i = 0; i < length; i++) {
      list.add(matrix[offset][offset + i]);
    }
    for (int i = 0; i < length; i++) {
      list.add(matrix[offset + i][offset + length]);
    }
    for (int i = 0; i < length; i++) {
      list.add(matrix[offset + length][offset + length - i]);
    }
    for (int i = 0; i < length; i++) {
      list.add(matrix[offset + length - i][offset]);
    }
    spiral(matrix, offset + 1, length - 2, list);
  }
}
