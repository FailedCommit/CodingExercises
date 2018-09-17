package com.leetcode;

public class BuySellStock {

  public static void main(String[] args) {
    BuySellStock bss = new BuySellStock();
    
    System.out.println(bss.maxProfit_question121(new int[]{7,1,5,3,6,4})); // 5
    System.out.println(bss.maxProfit_question121(new int[]{7,6,4,3,1}));  // 0
    System.out.println(bss.maxProfit_question121(new int[]{}));  // 0

  }
  
  public int maxProfit_question121(int[] prices) {
    int buy = 0;
    int sell = 0;
    int min = 0;
    int max = 0;
    int profit = 0;
    for(int i = 1; i < prices.length; i++) {
      if(prices[i] > prices[max]) max = i;
      if(prices[i] < prices[min]) {
        min = i;
        max = i;
      }
      if(prices[max] - prices[min] > profit) {
        buy = min;
        sell = max;
        profit = prices[sell] - prices[buy];
      }
    }
    return profit;
  }
}
