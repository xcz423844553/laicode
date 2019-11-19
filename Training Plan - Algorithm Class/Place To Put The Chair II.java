/*
Given a gym with k pieces of equipment without any obstacles.  Let’s say we bought a chair and wanted to put this chair into the gym such that the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ' ' denotes a cell without equipment. The cost of moving from one cell to its neighbor(left, right, up, down) is 1. You can put chair on any cell in the gym.

Assumptions

There is at least one equipment in the gym
The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null

Examples

{ { 'E', ' ', ' ' },
  {  ' ', 'E',  ' ' },
  {  ' ',  ' ', 'E' } }

we should put the chair at (1, 1), so that the sum of cost from the chair to the two equipments is 2 + 0 + 2 = 4, which is minimal.
*/

public class Solution {
  public List<Integer> putChair(char[][] gym) {
    List<Equip> equips = new ArrayList<>();
    for (int i = 0; i < gym.length; i++) {
      for (int j = 0; j < gym[0].length; j++) {
        if (gym[i][j] == 'E') {
          equips.add(new Equip(i, j));
        }
      }
    }
    int minDist = Integer.MAX_VALUE;
    int minX = 0;
    int minY = 0;
    for (int i = 0; i < gym.length; i++) {
      for (int j = 0; j < gym[0].length; j++) {
        int dist = 0;
        for (Equip e : equips) {
          dist += Math.abs(i - e.x);
          dist += Math.abs(j - e.y);
        }
        if (dist < minDist) {
          minDist = dist;
          minX = i;
          minY = j;
        }
      }
    }
    List<Integer> res = new ArrayList<>();
    res.add(minX);
    res.add(minY);
    return res;
  }
  class Equip {
    int x;
    int y;
    Equip(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
