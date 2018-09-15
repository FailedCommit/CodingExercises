package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 * 
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 */
public class MinimumIndexSum {

  public static void main(String[] args) {
    MinimumIndexSum mis = new MinimumIndexSum();
    String[] result1 =
        mis.findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
            new String[] {"KFC", "Shogun", "Burger King"});
    System.out.println(Arrays.toString(result1));

    String[] result2 = mis.findRestaurant(
        new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
        new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
    System.out.println(Arrays.toString(result2));

    String[] result3 =
        mis.findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
            new String[] {"KFC", "Burger King", "Tapioca Express", "Shogun"});
    System.out.println(Arrays.toString(result3));
  }

  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    for (String s : list1) {
      map.put(s, count++);
    }
    int min = Integer.MAX_VALUE;
    List<String> results = new ArrayList<>();
    count = -1;
    for (String s : list2) {
      count++;
      Integer index = map.get(s);
      if (index == null) continue;
      if (min > index + count) {
        results.clear();
        min = index + count;
        results.add(s);
      } else if (min == index + count) results.add(s);
    }
    return results.toArray(new String[0]);
  }
}
