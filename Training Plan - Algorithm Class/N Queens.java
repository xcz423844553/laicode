/*
Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

Assumptions

N > 0

Return

A list of ways of putting the N Queens
Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)

Example

N = 4, there are two ways of putting 4 queens:

[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
*/

public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> list = new ArrayList<>();
    if (n <= 0) return list;
    Integer[] queens = new Integer[n];
    for (int i = 0; i < n; i++) {
      queens[i] = i;
    }
    dfs(0, queens, list);
    return list;
  }
  private void dfs(int index, Integer[] queens, List<List<Integer>> list) {
    if (index == queens.length) {
      list.add(new ArrayList<Integer>(Arrays.asList(queens)));
      return;
    }
    for (int i = index; i < queens.length; i++) {
      swap(queens, index, i);
      if (isValid(queens, index)) {
        dfs(index + 1, queens, list);
      }
      swap(queens, index, i);
    }
  }
  private boolean isValid(Integer[] queens, int index) {
    for (int i = 0; i < index; i++) {
      int loc = queens[i];
      int dist = queens[index] - queens[i];
      if (dist == index - i || dist == i - index) return false;
    }
    return true;
  }
  private void swap(Integer[] array, int i1, int i2) {
    Integer temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }
}
