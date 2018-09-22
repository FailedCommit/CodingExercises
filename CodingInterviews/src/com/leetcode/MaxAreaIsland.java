package com.leetcode;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaIsland {

  public static void main(String[] args) {
    MaxAreaIsland msi = new MaxAreaIsland();
    
    int[][] a = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                 {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                 {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                 {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                 {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
    System.out.println(msi.maxAreaOfIsland(a));  // 6
    
    int[][] b = {{0,0,0,0,0,0,0,0}};
    System.out.println(msi.maxAreaOfIsland(b));  // 0
  }
  
  public int maxAreaOfIsland(int[][] a) {
    boolean[][] visited = new boolean[a.length][a[0].length];
    int maxArea = 0;
    
    for(int row = 0; row < a.length; row++) {
      for(int col = 0; col < a[row].length; col++) {
        if(a[row][col] == 0 || visited[row][col]) continue;
        maxArea = Math.max(maxArea, DFS(a, row, col, visited));
      }
    }
    return maxArea;
  }
  
  public int DFS(int[][] a, int row, int col, boolean[][] visited) {
    if(!isValidIndex(a, row, col) || visited[row][col] || a[row][col] == 0) return 0;
    
    visited[row][col] = true;
    return 1 + DFS(a, row, col+1, visited) +
               DFS(a, row, col-1, visited) +
               DFS(a, row+1, col, visited) +
               DFS(a, row-1, col, visited);  
  }

  private boolean isValidIndex(int[][] a, int i, int j) {
    return !(i < 0 || j < 0 || i >= a.length || j >= a[i].length);
  }
}
