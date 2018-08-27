package com.tools.TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.utils.Utils;

/**
 * Finds a path between given source and destination.
 * 0s can not be used in a path, only 1s are allowed.  
 */
public class DFS {
  public static void main(String[] args) {
    int[][] a = {
                    {1, 1, 0},  // true,  true, false
                    {0, 1, 0},  // false, true, false
                    {1, 1, 1}   // false, true, true
                };
    
    System.out.println("Given: " + Arrays.deepToString(a));

    DFS bfs = new DFS();
    bfs.search(a);
    
    System.out.println(Arrays.deepToString(a));
  }

  private void search(int[][] a) {
    if(a.length == 0) return;
    boolean[][] visited = new boolean[a.length][a[0].length];
    System.out.println("Path Found: " + performDFS(a, 0, 0, visited));
    System.out.println(Arrays.deepToString(visited));
  }

  private boolean performDFS(int[][] a, int i, int j, boolean[][] visited) {
    if(i == a.length-1 && j == a[0].length -1) {
      visited[i][j] = true;
      return true;
    }
    List<MatrixNode> neighbors = findNeighbors(a, i, j);
    for(MatrixNode neighbor : neighbors) {
      if(visited[i][j]) continue; 
      visited[i][j] = true;
      boolean destinationFound = performDFS(a, neighbor.x, neighbor.y, visited);
      if(!destinationFound) {
        visited[i][j] = false;
      } else {
        return true;
      }
    }
    return false;
  }

  private List<MatrixNode> findNeighbors(int[][]a, int i, int j) {
    int[] x = {0, 0, 1, -1};
    int[] y = {1, -1, 0, 0};
    List<MatrixNode> neighbors = new ArrayList<>();
    for(int k = 0; k < x.length; k++) {
      if(Utils.isValidIndex(a, x[k] + i, y[k] + j) && a[x[k] + i][y[k] + j] == 1) {
        MatrixNode n = new MatrixNode();
        n.x = x[k] + i;
        n.y = y[k] + j;
        neighbors.add(n);
      }
    }
    return neighbors;
  }
}
