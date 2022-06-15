package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

//Priority Queue implements and work same as MinHeap
//Note:- here we have used Max heap to find out smallest element. To find Largest element use Min Heap
public class KthSmallestElement {

    //start is the starting of array i.e. 0
    //end is the last element of array
    //k is the kth element which needs to find
    int kthSmallest(int arr[], int start, int end, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //step 1
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        //step 2
        for (int i = k; i <= end; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 20, 15};
        KthSmallestElement k = new KthSmallestElement();
        System.out.println(k.kthSmallest(arr, 0, arr.length-1, 4));
    }
}
