package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestSumSubarray {
    //APPROACH 1    - Space complexity O(n2)    Time complexity: O(n^2 log (k))
    int getKthLargestSumWithoutHeap(int[] arr, int k) {
        ArrayList<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                sumList.add(sum);
                System.out.println(sum);
            }
        }
        System.out.println("************");
        Collections.sort(sumList);
        int sumListLen = sumList.size();
        return sumList.get(sumListLen - k);

    }

    //APPROACH 2    -  Space complexity O(k)    Time complexity: O(n^2 log (k))
    int getKthLargestSumWithHeap(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (pq.size() < k) {
                    pq.add(sum);
                } else if (pq.peek() < sum) {
                    pq.poll();
                    pq.add(sum);
                }
            }
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};          //1 3 4 2 5 3 -> 1 2 3 3 4 5
        KthLargestSumSubarray kthSmallestElement = new KthLargestSumSubarray();
        int k = 1;
        int ans = kthSmallestElement.getKthLargestSumWithoutHeap(arr, k);
        System.out.println(ans);
        System.out.println("************________________***********");
        int m = 1;
        int ans2 = kthSmallestElement.getKthLargestSumWithHeap(arr, m);
        System.out.println(ans2);
    }
}
