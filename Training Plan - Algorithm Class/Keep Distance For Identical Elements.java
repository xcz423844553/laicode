/*
Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:

Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).

If there does not exist such sequence, return null.

Assumptions:

k is guaranteed to be > 0

Examples:

k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
*/

public class Solution {
  public int[] keepDistance(int k) {
    int[] result = new int[2 * k];
    boolean[] used = new boolean[k];
    boolean b = keepDistance(k, 0, used, result);
    return b ? result : null;
  }
  private boolean keepDistance(int k, int index, boolean[] used, int[] result) {
    if (index >= 2 * k) {
      return true;
    }
    if (result[index] != 0) {
      return keepDistance(k, index + 1, used, result);
    }
    for (int i = 1; i <= k; i++) {
      if (!used[i - 1] && index + i + 1 < result.length && result[index + i + 1] == 0) {
        result[index] = i;
        result[index + i + 1] = i;
        used[i - 1] = true;
        boolean b = keepDistance(k, index + 1, used, result);
        if (b) return true;
        result[index] = 0;
        result[index + i + 1] = 0;
        used[i - 1] = false;
      }
    }
    return false;
  }
}
