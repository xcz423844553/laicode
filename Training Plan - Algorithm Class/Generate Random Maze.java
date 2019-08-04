/*
Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall’s width are both 1 cell. For each pair of cells on the corridor, there must exist one and only one path between them. (Randomly means that the solution is generated randomly, and whenever the program is executed, the solution can be different.). The wall is denoted by 1 in the matrix and corridor is denoted by 0.

Assumptions

N = 2K + 1 and K >= 0
the top left corner must be corridor
there should be as many corridor cells as possible
for each pair of cells on the corridor, there must exist one and only one path between them

Examples

N = 5, one possible maze generated is

        0  0  0  1  0
        1  1  0  1  0
        0  1  0  0  0
        0  1  1  1  0
        0  0  0  0  0
*/

public class Solution {
  public int[][] maze(int n) {
	    int[][] m = new int[n][n];
	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < n; j++) {
	        m[i][j] = 1;
	      }
	    }
	    m[0][0] = 0;
	    startMove(m, 0, 0);
	    return m;
	  }
	  private void startMove(int[][] m, int x, int y) {
	    Dir[] dir = generateRandomDir(m, x, y);
	    for (int i = 0; i < dir.length; i++) {
	      Dir d = dir[i];
	      int nextX = x + d.x * 2;
	      int nextY = y + d.y * 2;
	      if (!isValidMove(nextX, nextY, m)) {
	        continue;
	      }
	      if (shouldMove(nextX, nextY, m)) {
	        m[nextX][nextY] = 0;
	        m[x + d.x][y + d.y] = 0;
	        startMove(m, nextX, nextY);
	      }
	    }
	    return;
	  }
	  private boolean shouldMove(int x, int y, int[][] m) {
	    int up = x - 1 < 0 ? 1 : m[x - 1][y];
	    int down = x + 1 >= m.length ? 1 : m[x + 1][y];
	    int left = y - 1 < 0 ? 1 : m[x][y - 1];
	    int right = y + 1 >= m.length ? 1 : m[x][y + 1];
	    if (up + down + left + right < 3) return false;
	    return true;
	  }
	  private boolean isValidMove(int x, int y, int[][] m) {
	    int n = m.length;
	    return x >= 0 && x < n && y >= 0 && y < n && m[x][y] == 1;
	  }
	  private Dir[] generateRandomDir(int[][] m, int x, int y) {
	    Dir[] list = new Dir[4];
	    list[0] = new Dir(1, 0);
	    list[1] = new Dir(-1, 0);
	    list[2] = new Dir(0, 1);
	    list[3] = new Dir(0, -1);
	    for (int i = 0; i < list.length; i++) {
	      int randomIndex = i + new Random().nextInt(list.length - i);
	      swap(list, randomIndex, i);
	    }
	    return list;
	  }
	  private void swap(Dir[] list, int i, int j) {
	    Dir temp = list[i];
	    list[i] = list[j];
	    list[j] = temp;
	  }
	  class Dir {
	    int x;
	    int y;
	    public Dir(int x, int y) {
	      this.x = x;
	      this.y = y;
	    }
	  }
}
