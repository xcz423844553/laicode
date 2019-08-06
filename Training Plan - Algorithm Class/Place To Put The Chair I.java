/*
Given a gym with k pieces of equipment and some obstacles.  We bought a chair and wanted to put this chair into the gym such that  the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ‘O’ denotes a cell with an obstacle, 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. You can not put the chair on a cell with equipment or obstacle.

Assumptions

There is at least one equipment in the gym
The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
It is guaranteed that each 'C' cell is reachable from all 'E' cells.
If there does not exist such place to put the chair, just return {-1, -1}

Examples

{ { 'E', 'O', 'C' },
  {  'C', 'E',  'C' },
  {  'C',  'C',  'C' } }

we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.
*/

public class Solution {
  public List<Integer> putChair(char[][] gym) {
    List<Equip> equipList = new ArrayList<>();
    for (int i = 0; i < gym.length; i++) {
      for (int j = 0; j < gym[0].length; j++) {
        if (gym[i][j] == 'E') {
          equipList.add(new Equip(i, j, gym));
        }
      }
    }
    List<Integer> closest = new ArrayList<>();
    closest.add(-1);
    closest.add(-1);
    int closestDist = Integer.MAX_VALUE;
    for (int i = 0; i < gym.length; i++) {
      for (int j = 0; j < gym[0].length; j++) {
        if (gym[i][j] == 'C') {
          int sumDist = 0;
          for (Equip e : equipList) {
            sumDist += e.dist[i][j];
          }
          if (sumDist < closestDist) {
            closestDist = sumDist;
            closest.set(0, i);
            closest.set(1, j);
          }
        }
      }
    }
    return closest; 
  }
  class Equip {
    public int x;
    public int y;
    public int[][] dist;
    public Equip(int x, int y, char[][] gym) {
      this.x = x;
      this.y = y;
      this.dist = updateDist(x, y, gym);
    }
    public int[][] updateDist(int x, int y, char[][] gym) {
      boolean[][] visited = new boolean[gym.length][gym[0].length];
      final int[][] dist = new int[gym.length][gym[0].length];
      PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
          int d1 = dist[l1.get(0)][l1.get(1)];
          int d2 = dist[l2.get(0)][l2.get(1)];
          if (d1 == d2) return 0;
          return d1 < d2 ? -1 : 1;
        }
      });
      visited[x][y] = true;
      pq.offer(Arrays.asList(new Integer[]{x, y}));
      while (!pq.isEmpty()) {
        List<Integer> cell = pq.poll();
        int cellDist = dist[cell.get(0)][cell.get(1)];
        if (cell.get(0) + 1 < gym.length && !visited[cell.get(0) + 1][cell.get(1)]) {
          if (gym[cell.get(0) + 1][cell.get(1)] == 'O') {
            dist[cell.get(0) + 1][cell.get(1)] = Integer.MAX_VALUE;
            visited[cell.get(0) + 1][cell.get(1)] = true;
          } else {
            dist[cell.get(0) + 1][cell.get(1)] = cellDist + 1;
            visited[cell.get(0) + 1][cell.get(1)] = true;
            pq.offer(Arrays.asList(new Integer[]{cell.get(0) + 1, cell.get(1)}));
          }
        }
        if (cell.get(1) + 1 < gym[0].length && !visited[cell.get(0)][cell.get(1) + 1]) {
          if (gym[cell.get(0)][cell.get(1) + 1] == 'O') {
            dist[cell.get(0)][cell.get(1) + 1] = Integer.MAX_VALUE;
            visited[cell.get(0)][cell.get(1) + 1] = true;
          } else {
            dist[cell.get(0)][cell.get(1) + 1] = cellDist + 1;
            visited[cell.get(0)][cell.get(1) + 1] = true;
            pq.offer(Arrays.asList(new Integer[]{cell.get(0), cell.get(1) + 1}));
          }
        }
        if (cell.get(0) - 1 >= 0 && !visited[cell.get(0) - 1][cell.get(1)]) {
          if (gym[cell.get(0) - 1][cell.get(1)] == 'O') {
            dist[cell.get(0) - 1][cell.get(1)] = Integer.MAX_VALUE;
            visited[cell.get(0) - 1][cell.get(1)] = true;
          } else {
            dist[cell.get(0) - 1][cell.get(1)] = cellDist + 1;
            visited[cell.get(0) - 1][cell.get(1)] = true;
            pq.offer(Arrays.asList(new Integer[]{cell.get(0) - 1, cell.get(1)}));
          }
        }
        if (cell.get(1) - 1 >= 0 && !visited[cell.get(0)][cell.get(1) - 1]) {
          if (gym[cell.get(0)][cell.get(1) - 1] == 'O') {
            dist[cell.get(0)][cell.get(1) - 1] = Integer.MAX_VALUE;
            visited[cell.get(0)][cell.get(1) - 1] = true;
          } else {
            dist[cell.get(0)][cell.get(1) - 1] = cellDist + 1;
            visited[cell.get(0)][cell.get(1) - 1] = true;
            pq.offer(Arrays.asList(new Integer[]{cell.get(0), cell.get(1) - 1}));
          }
        }
      }
      return dist;
    }
  }
}
