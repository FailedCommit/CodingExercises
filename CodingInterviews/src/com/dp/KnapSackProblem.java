package com.dp;

public class KnapSackProblem {
  
  private int[][] knapsackTable;
  private int[] weights;
  private int[] values;
  private int totalItems;
  private int totalBenefit;
  private int capacityOfKnapsack;
  
  public KnapSackProblem(
      int totalItems,
      int[] weights,
      int[] values,
      int capacityOfKnapsack) {
    this.totalItems = totalItems;
    this.weights = weights;
    this.values = values;
    this.knapsackTable = new int[totalItems + 1][capacityOfKnapsack + 1];
    this.capacityOfKnapsack = capacityOfKnapsack;
  }
  
  public void solve() { // Complexity: O(n*w)
    for(int i = 1; i < totalItems + 1; i++) {
      for(int w = 1; w < capacityOfKnapsack + 1; w++) {
        int itemLeft = knapsackTable[i - 1][w];
        int itemTaken = 0;
        if(weights[i] <= w) {
          itemTaken = values[i] + knapsackTable[i - 1][w - weights[i]];
        }
        knapsackTable[i][w] = Math.max(itemLeft, itemTaken);
      }
    }
    totalBenefit = knapsackTable[totalItems][capacityOfKnapsack];
  }
  
  public void showResult() {
    System.out.println("Total Benefit: " + totalBenefit);
    for(int n = totalItems, w = capacityOfKnapsack;
        n > 0 && knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n-1][w];
        n--) {
      System.out.println("We take item #" + n);
      w = w - weights[n];
    }
  }

  public static void main(String[] args) {
    int totalItems = 3;
    int capacityOfKnapsack = 5;
    int[] weights = {0, 4, 2, 3}; // Extra leading zero to accommodate zero weight.
    int[] values = {0, 10, 4, 7};
    
    KnapSackProblem knapsack = new KnapSackProblem(totalItems, weights, values, capacityOfKnapsack);
    knapsack.solve();
    knapsack.showResult();
  }

}
