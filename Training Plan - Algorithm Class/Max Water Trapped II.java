/*
Given a non-negative integer 2D array representing the heights of bars in a matrix. Suppose each bar has length and width of 1. Find the largest amount of water that can be trapped in the matrix. The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height. Each bar has 4 neighboring bars to the left, right, up and down side.

Assumptions

The given matrix is not null and has size of M * N, where M > 0 and N > 0, all the values are non-negative integers in the matrix.

Examples

{ { 2, 3, 4, 2 },
  { 3, 1, 2, 3 },
  { 4, 3, 5, 4 } }

the amount of water can be trapped is 3, 

at position (1, 1) there is 2 units of water trapped,

at position (1, 2) there is 1 unit of water trapped.
*/

public class Solution {
  public int maxTrapped(int[][] matrix) {
    PriorityQueue<Cell> pq = new PriorityQueue<>(1, new Comparator<Cell>() {
      public int compare(Cell c1, Cell c2) {
        if (c1.level == c2.level) return 0;
        return c1.level > c2.level ? 1 : -1;
      }
    });
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      visited[i][0] = true;
      visited[i][matrix[0].length - 1] = true;
      pq.offer(new Cell(i, 0, matrix[i][0], matrix[i][0]));
      pq.offer(new Cell(i, matrix[0].length - 1, matrix[i][matrix[0].length - 1], matrix[i][matrix[0].length - 1]));
    }        
    for (int i = 0; i < matrix[0].length; i++) {
      visited[0][i] = true;
      visited[matrix.length - 1][i] = true;
      pq.offer(new Cell(0, i, matrix[0][i], matrix[0][i]));
      pq.offer(new Cell(matrix.length - 1, i, matrix[matrix.length - 1][i], matrix[matrix.length - 1][i]));
    }
    while (!pq.isEmpty()) {
      Cell c = pq.poll();
      if (c.i - 1 >= 0 && !visited[c.i - 1][c.j]) {
        Cell nei = new Cell(c.i - 1, c.j, Math.max(c.level, matrix[c.i - 1][c.j]), matrix[c.i - 1][c.j]);
        visited[c.i - 1][c.j] = true;
        pq.offer(nei);
        sum += nei.level - nei.height;
      }
      if (c.i + 1 < matrix.length && !visited[c.i + 1][c.j]) {
        Cell nei = new Cell(c.i + 1, c.j, Math.max(c.level, matrix[c.i + 1][c.j]), matrix[c.i + 1][c.j]);
        visited[c.i + 1][c.j] = true;
        pq.offer(nei);
        sum += nei.level - nei.height;
      }
      if (c.j - 1 >= 0 && !visited[c.i][c.j - 1]) {
        Cell nei = new Cell(c.i, c.j - 1, Math.max(c.level, matrix[c.i][c.j - 1]), matrix[c.i][c.j - 1]);
        visited[c.i][c.j - 1] = true;
        pq.offer(nei);
        sum += nei.level - nei.height;
      }
      if (c.j + 1 < matrix[0].length && !visited[c.i][c.j + 1]) {
        Cell nei = new Cell(c.i, c.j + 1, Math.max(c.level, matrix[c.i][c.j + 1]), matrix[c.i][c.j + 1]);
        visited[c.i][c.j + 1] = true;
        pq.offer(nei);
        sum += nei.level - nei.height;
      }
    }
    return sum;
  }
  class Cell {
    int i;
    int j;
    int level;
    int height;
    public Cell(int i, int j, int level, int height) {
      this.i = i;
      this.j = j;
      this.level = level;
      this.height = height;
    }
  }
}
