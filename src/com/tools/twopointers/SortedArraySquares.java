package com.tools.twopointers;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        // TODO: Write your code here
        return squares;
    }

    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
        result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
