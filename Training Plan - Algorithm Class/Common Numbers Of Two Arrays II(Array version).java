/*
Find all numbers that appear in both of two unsorted arrays.

Assumptions

Both of the two arrays are not null.
In any of the two arrays, there could be duplicate numbers.

Examples

A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)

*/

public class Solution {
  public List<Integer> common(int[] a, int[] b) {
    List<Integer> result = new ArrayList<>();
    Arrays.sort(a);
    Arrays.sort(b);
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        i++;
      } else if (a[i] > b[j]) {
        j++;
      } else {
        result.add(a[i]);
        i++;
        j++;
      }
    }
    return result;
  }
}
