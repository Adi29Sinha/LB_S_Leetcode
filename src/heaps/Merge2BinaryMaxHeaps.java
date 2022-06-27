package heaps;

import java.util.ArrayList;

public class Merge2BinaryMaxHeaps {

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //check if the current node is maxheap respective, checking the left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        //check if the current node is maxheap respective, checking the right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = 0;
        temp = arr[i1];
        arr[i1] = arr[i];
        arr[i] = temp;
    }

    static int[] mergeHeaps(int[] heap1, int[] heap2, int n, int m) {
        int[] ans = new int[n + m];
        for (int j = 0; j < n; j++) {
            ans[j] = heap1[j];
        }
        for (int j = 0; j < m; j++) {
            ans[n + j] = heap2[j];
        }
        int size = ans.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(ans, size, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};
        int n = a.length;
        int m = b.length;

        int[] merged = new int[m + n];

        int[] ans = mergeHeaps(a, b, n, m);

        for (int i = 0; i < m + n; i++)
            System.out.print(ans[i] + " ");
        System.out.println();
    }
}
