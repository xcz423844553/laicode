/*
Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".

There should not be extra zeros on the left side.

Examples

0's hex representation is "0x0"
255's hex representation is "0xFF"
*/

public class Solution {
  public String hex(int number) {
    if (number == 0) return "0x0";
    StringBuilder sb = new StringBuilder();
    while (number != 0) {
      char c = getHex(number & 15);
      sb.append(c);
      number = number >>> 4;
    }
    sb.append("x0");
    sb.reverse();
    return sb.toString();
  }
  private char getHex(int number) {
    if (number <= 9) {
      return (char)(number + '0');
    } else {
      return (char)(number - 10 + 'A');
    }
  }
}
