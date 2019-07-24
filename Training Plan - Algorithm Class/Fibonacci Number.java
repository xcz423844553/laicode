/*
Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

Examples

0th fibonacci number is 0
1st fibonacci number is 1
2nd fibonacci number is 1
3rd fibonacci number is 2
6th fibonacci number is 8

Corner Cases

What if K < 0? in this case, we should always return 0.
Is it possible the result fibonacci number is overflowed? We can assume it will not be overflowed when we solve this problem on this online judge, but we should also know that it is possible to get an overflowed number, and sometimes we will need to use something like BigInteger.
*/

public class Solution {
  public long fibonacci(int K) {
    if (K < 0) return 0L;
    long num0 = 0;
    long num1 = 1;
    if (K == 0) return num0;
    if (K == 1) return num1;
    for (int i = 2; i <= K; i++) {
      long num2 = num0 + num1;
      num0 = num1;
      num1 = num2; 
    }
    return num1;
  }
}
