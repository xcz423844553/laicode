/*
Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random1000()
*/

public class Solution {
  public int random1000() {
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    // 5^3 = 125; 5^4 = 625; 5^5 = 3125
    int r = 0;
    for (int i = 0; i < 5; i++) {
      r = r * 5 + RandomFive.random5();
    }
    if (r < 3000) {
      return r % 1000;
    }
    return random1000();
  }
}
