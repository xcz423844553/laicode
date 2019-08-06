/*
Find all common elements in K sorted lists.

Assumptions

The input and its elements are not null, and support fast random access.

There could be duplicate elements in each of the lists.

Examples

Input = {{1, 2, 2, 3}, {2, 2, 3, 5}, {2, 2, 4}}, the common elements are {2, 2}.
*/

public class Solution {
  public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
    if (input == null || input.size() == 0) return new ArrayList<Integer>();
    List<Integer> cur = input.get(0);
    for (int i = 1; i < input.size(); i++) {
      List<Integer> temp = new ArrayList<>();
      List<Integer> list = input.get(i);
      int j = 0, k = 0;
      while (j < cur.size() && k < list.size()) {
        if (cur.get(j) < list.get(k)) {
          j++;
        } else if (cur.get(j) > list.get(k)) {
          k++;
        } else {
          temp.add(cur.get(j));
        }
      }
      cur = temp;
    }
    return cur;
  }
}
