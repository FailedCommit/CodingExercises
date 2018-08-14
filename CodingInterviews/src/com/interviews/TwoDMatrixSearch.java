package com.interviews;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 *   Integers in each row are sorted in ascending from left to right.
 *   Integers in each column are sorted in ascending from top to bottom.
 *   Example:
 *   
 *   Consider the following matrix:
 *   
 *     [
 *        [1,   4,  7, 11, 15],
 *        [2,   5,  8, 12, 19],
 *        [3,   6,  9, 16, 22],
 *        [10, 13, 14, 17, 24],
 *        [18, 21, 23, 26, 30]
 *      ]
 *   
 *   Given target = 5, return true.
 *   
 *   Given target = 20, return false. 
 *
 */
public class TwoDMatrixSearch {
  
  /**
   * Searches the given matrix for target element on O(n) complexity.
   * <br/>
   * <br/>Since, rows and columns are sorted Binary search is also a 
   * <br/>potential algo here but not as efficient as the below algorithm.
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0) return false;
    int i = 0;
    int j = matrix[i].length -1;
    while(i < matrix.length && j >= 0) {
        int e = matrix[i][j];
        //System.out.print(e + " ");
        if(e == target) return true;
        else if(e < target) i++;
        else j--;
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {
                              {1,   4,  7, 11, 15},
                              {2,   5,  8, 12, 19},
                              {3,   6,  9, 16, 22},
                              {10, 13, 14, 17, 24},
                              {18, 21, 23, 26, 30}
                     };
    TwoDMatrixSearch ms = new TwoDMatrixSearch();
    System.out.println("The given matrix contains element 5 : " + ms.searchMatrix(matrix, 5));
    System.out.println("The given matrix contains element 20 : " + ms.searchMatrix(matrix, 20));
    System.out.println("The given matrix contains element 18 : " + ms.searchMatrix(matrix, 18));
    System.out.println("The given matrix contains element 15 : " + ms.searchMatrix(matrix, 15));
    System.out.println("The given matrix contains element 100 : " + ms.searchMatrix(matrix, 100));

  }

}
