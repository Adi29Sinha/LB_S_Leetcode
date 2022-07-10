package common;

import java.util.Arrays;

public class SortedSquares {
    /*
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
     */
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];

        Arrays.sort(arr);

        return arr;
    }
}
