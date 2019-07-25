/*
Reverse bits of a 32-bit integer. 

Note: In different programming languages, integers might be implemented differently in terms of number of bits, signed, unsigned, etc. However it should not affect your implementation on this problem. In java, the type of input is long, but you just need to work on the last 32-bit and consider it as an unsigned 32-bit integer.

Example 1:

Input: 1234 (0b'00000000000000000000010011010010)

Output: 1260388352 (0b'01001011001000000000000000000000)
*/

public class Solution {
  public long reverseBits(long n) {
    long res = 0;
    for (long i = 0L; i < 32L; i++) {
      long digit = (n >> i) & 1L;
      res |= digit << (31 - i);
    }
    return res;
  }
}
