/*
Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

Assumptions

In each of the two sorted arrays, there could be duplicate numbers.
Both two arrays are not null.

Examples

A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
*/

public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    List<Integer> result = new ArrayList<>();
    int idxA = 0, idxB = 0;
    while (idxA < A.size() && idxB < B.size()) {
      if (A.get(idxA).equals(B.get(idxB))) {
        result.add(A.get(idxA));
        idxA++;
        idxB++;
      } else if (A.get(idxA) > (B.get(idxB))) {
        idxB++;
      } else {
        idxA++;
      }
    }
    return result;
  }
}
