package com.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/word-search/description/
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {

  public static void main(String[] args) {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    WordSearch ws = new WordSearch();
    System.out.println("Exists: " + ws.exist(board, "ABCCED")); // true
    System.out.println(Arrays.deepToString(board));
    System.out.println("Exists: " + ws.exist(board, "SEE")); // true
    System.out.println("Exists: " + ws.exist(board, "ABCB")); // false
  }

  public boolean exist(char[][] board, String word) {
    int rows = board.length-1;
    int cols = board[0].length-1;

    boolean result = false;
    for (int i = 0; i <= rows; i++) {
      for (int j = 0; j <= cols; j++) {
        if (dfs(board, word, i, j, 0)) {
          result = true;
        }
      }
    }
    return result;
  }

  public boolean dfs(char[][] board, String word, int row, int col, int k) {
    int maxRow = board.length-1;
    int maxCol = board[0].length-1;

    if (row < 0 || col < 0 || row > maxRow || col > maxCol) {
      return false;
    }

    if (board[row][col] == word.charAt(k)) {
      char temp = board[row][col];
      board[row][col] = '#';
      if (k == word.length() - 1) {
        board[row][col] = temp;
        return true;
      } else if (dfs(board, word, row - 1, col, k + 1) || dfs(board, word, row + 1, col, k + 1)
          || dfs(board, word, row, col - 1, k + 1) || dfs(board, word, row, col + 1, k + 1)) {
        board[row][col] = temp;
        return true;
      }
      board[row][col] = temp;
    }

    return false;
  }
}
