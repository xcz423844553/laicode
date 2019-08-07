/*
Given a stream of characters, find the first non-repeating character from stream. You need to tell the first non-repeating character in O(1) time at any moment.

Implement two methods of the class:

read() - read one character from the stream
firstNonRepeating() - return the first non-repoeating character from the stream at any time when calling the method, return null if there does not exist such characters

Examples:

read:

a   b   c   a   c   c    b

firstNonRepeating:

a   a   a   b   b   b   null
*/

public class Solution {
  private Set<Character> set;
  private List<Character> list;
  public Solution() {
    set = new HashSet<>();
    list = new LinkedList<>();
  }
  
  public void read(char ch) {
    if (set.add(ch)) {
      list.add(ch);
    } else {
      list.remove(new Character(ch));
    }
  }
  
  public Character firstNonRepeating() {
    return list.isEmpty() ? null : list.get(0);
  }
}
