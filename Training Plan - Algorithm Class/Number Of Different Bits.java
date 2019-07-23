/*
Determine the number of bits that are different for two given integers.

Examples

5(“0101”) and 8(“1000”) has 3 different bits
*/

public class Solution {
  public int diffBits(int a, int b) {
    int diff = a ^ b;
    int count = 0;
    while (diff != 0) {
      count += diff & 1;
      diff = diff >>> 1;
    }
    return count;
  }
}
