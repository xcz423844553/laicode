/*
Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.

Assumptions

Both arrays are not null.
There are no duplicate numbers in each of the two arrays respectively.

Exmaples

A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
A = {}, B = {3, 1, 4}, return []
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
