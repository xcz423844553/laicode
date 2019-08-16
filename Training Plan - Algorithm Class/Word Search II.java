/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

public class Solution {
  public List<String> findWords(char[][] board, String[] words) {
    TrieNode dict = new TrieNode(' ', false);
    for (String s : words) {
      TrieNode cur = dict;
      for (int i = 0; i < s.length(); i++) {
        cur = cur.addNext(s.charAt(i), i == s.length() - 1);
      }
    }
    boolean[][] visited = new boolean[board.length][board[0].length];
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dict.next.containsKey(board[i][j])) {
          visited[i][j] = true;
          sb.append(board[i][j]);
          dfs(i, j, board, visited, dict.next.get(board[i][j]), sb, result);
          sb.deleteCharAt(sb.length() - 1);
          visited[i][j] = false;
        }
      }
    }
    return result;
  }
  private void dfs(int row, int col, char[][] board, boolean[][] visited, TrieNode node, StringBuilder sb, List<String> result) {
    if (node.isWord) {
      result.add(sb.toString());
      node.isWord = false;
      return;
    }
    if (row + 1 < board.length && !visited[row + 1][col] && node.next.containsKey(board[row + 1][col])) {
      visited[row + 1][col] = true;
      sb.append(board[row + 1][col]);
      dfs(row + 1, col, board, visited, node.next.get(board[row + 1][col]), sb, result);
      sb.deleteCharAt(sb.length() - 1);
      visited[row + 1][col] = false;
    }
    if (row - 1 >= 0 && !visited[row - 1][col] && node.next.containsKey(board[row - 1][col])) {
      visited[row - 1][col] = true;
      sb.append(board[row - 1][col]);
      dfs(row - 1, col, board, visited, node.next.get(board[row - 1][col]), sb, result);
      sb.deleteCharAt(sb.length() - 1);
      visited[row - 1][col] = false;
    }
    if (col + 1 < board[0].length && !visited[row][col + 1] && node.next.containsKey(board[row][col + 1])) {
      visited[row][col + 1] = true;
      sb.append(board[row][col + 1]);
      dfs(row, col + 1, board, visited, node.next.get(board[row][col + 1]), sb, result);
      sb.deleteCharAt(sb.length() - 1);
      visited[row][col + 1] = false;
    }
    if (col - 1 >= 0 && !visited[row][col - 1] && node.next.containsKey(board[row][col - 1])) {
      visited[row][col - 1] = true;
      sb.append(board[row][col - 1]);
      dfs(row, col - 1, board, visited, node.next.get(board[row][col - 1]), sb, result);
      sb.deleteCharAt(sb.length() - 1);
      visited[row][col - 1] = false;
    }
  }
  class TrieNode {
    char c;
    boolean isWord;
    Map<Character, TrieNode> next;
    public TrieNode(char c, boolean isWord) {
      this.c = c;
      this.isWord = isWord;
      this.next = new HashMap<Character, TrieNode>();
    }
    public TrieNode addNext(char c, boolean isWord) {
      if (next.containsKey(c)) {
        if (isWord) {
          next.get(c).isWord = isWord;
        }
        return next.get(c);
      } else {
        TrieNode n = new TrieNode(c, isWord);
        next.put(c, n);
        return n;
      }
    }
  }
}
