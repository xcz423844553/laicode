/*
Given a list of integers representing the lengths of urls, find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).

Assumptions

The maximum length of valid url is 4096

The list is not null and is not empty and does not contain null

Examples

[1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.
*/

public class Solution {
  public int percentile95(List<Integer> lengths) {
    int[] count = new int[4096];
    for (Integer i : lengths) {
      count[i - 1]++;
    }
    int sum = 0;
    double limit = lengths.size() * 0.95;
    for (int i = 0; i < count.length; i++) {
      sum += count[i];
      if (sum >= limit) {
        return i + 1;
      }
    }
    return 0;
  }
}
