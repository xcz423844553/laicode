/*
Given an integer number n, find its integer square root.

Assumption:

n is guaranteed to be >= 0.

Example:

Input: 18, Return: 4

Input: 4, Return: 2
*/

public class Solution {
  public int sqrt(int x) {
    long y = (long) x;
    for (long i = 0L; i <= y; i++) {
      if ((i + 1) * (i + 1) > y) {
        return (int) i;
      }
    }
    return 0;
  }
}
