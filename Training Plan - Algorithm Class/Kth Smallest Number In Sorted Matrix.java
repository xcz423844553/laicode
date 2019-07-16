/*
Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Assumptions

the matrix is not null, N > 0 and M > 0
K > 0 and K <= N * M

Examples

{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }

the 5th smallest number is 4
the 8th smallest number is 6
*/

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int numRow = matrix.length;
    int numCol = matrix[0].length;
    boolean[][] visited = new boolean[numRow][numCol];
    PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>(){
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.val == c2.val) return 0;
        return c1.val < c2.val ? -1 : 1;
      }
    });
    visited[0][0] = true;
    pq.offer(new Cell(0, 0, matrix[0][0]));
    while (k > 1) {
      Cell c = pq.poll();
      if (c.x + 1 < numRow && !visited[c.x + 1][c.y]) {
        pq.offer(new Cell(c.x + 1, c.y, matrix[c.x + 1][c.y]));
        visited[c.x + 1][c.y] = true;
      }
      if (c.y + 1 < numCol && !visited[c.x][c.y + 1]) {
        pq.offer(new Cell(c.x, c.y + 1, matrix[c.x][c.y + 1]));
        visited[c.x][c.y + 1] = true;
      }
      k--;
    }
    return pq.poll().val;
  }
  class Cell {
    int x, y, val;
    public Cell(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }
}
