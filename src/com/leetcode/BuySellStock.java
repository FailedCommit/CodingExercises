package com.leetcode;

public class BuySellStock {

  public static void main(String[] args) {
    BuySellStock bss = new BuySellStock();
    
    System.out.println(bss.maxProfit_question121(new int[]{7,1,5,3,6,4})); // 5
    System.out.println(bss.maxProfit_question121(new int[]{7,6,4,3,1}));  // 0
    System.out.println(bss.maxProfit_question121(new int[]{}));  // 0

  }
  
  public int maxProfit_question121(int[] prices) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
        if (prices[i] < minprice)
            minprice = prices[i];
        else if (prices[i] - minprice > maxprofit)
            maxprofit = prices[i] - minprice;
    }
    return maxprofit;
  }
}
