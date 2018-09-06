package com.backtracking;

public class NQueenProblem {
  
  private int[][] chessBoard;
  private int numOfQueens;
  
  public NQueenProblem(int numOfQueens) {
    this.chessBoard = new int[numOfQueens][numOfQueens];
    this.numOfQueens = numOfQueens;
  }
  
  public void solve() {
    if(setQueens(0)) {
      printQueens();
    } else {
      System.out.println("There is no solution...");
    }
  }
  

  private boolean setQueens(int colIndex) {
    if(colIndex == numOfQueens) return true;
    
    for(int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {
      if(isPlaceValid(rowIndex, colIndex)) {
        chessBoard[rowIndex][colIndex] = 1;
        if(setQueens(colIndex + 1)) return true;
      }
      // BACKTRACKING !!!
      chessBoard[rowIndex][colIndex] = 0;
    }
    return false; 
  }

  private boolean isPlaceValid(int rowIndex, int colIndex) {
    for(int i = 0; i < colIndex; i++) {
      if(chessBoard[rowIndex][i] == 1) return false;
    }
    for(int i = rowIndex, j = colIndex; i >=0 && j>=0; i--, j--) {
      if(chessBoard[i][j] == 1) return false;
    }
    for(int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0; i++, j--) {
      if(chessBoard[i][j] == 1) return false;
    }
    return true;
  }

  private void printQueens() {
    for(int i = 0; i < chessBoard.length; i++) {
      for(int j = 0; j < chessBoard.length; j++) {
        if(chessBoard[i][j] == 1) {
          System.out.print(" + ");
        } else {
          System.out.print(" - ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    NQueenProblem nqp = new NQueenProblem(3);
    nqp.solve();
    System.out.println("\n\n");
    nqp = new NQueenProblem(4);
    nqp.solve();
    System.out.println("\n\n");
    nqp = new NQueenProblem(8);
    nqp.solve();

  }

}
