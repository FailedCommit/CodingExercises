package com.tools.twopointers;

import java.util.List;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        // TODO: Write your code here
        return -1;
    }

    public static List<List<Integer>> searchActualTriplets(int[] arr, int target) {
        // TODO: Write your code here
        return null;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));

        System.out.println(TripletWithSmallerSum.searchActualTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchActualTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
