package heaps;


/**
 * TC of Insertion and Deletion is O(log N)
 */
public class Heap {
    int[] arr = new int[100];
    int size = 0;

    void insert(int val) {
        size += 1;
        int index = size;
        arr[index] = val;

        while (index > 1) {
            int parent = index / 2;
            if (arr[parent] < arr[index]) {
                swap(parent, index);
                index = parent;
            } else {
                return;
            }
        }
    }

    private void swap(int i, int i1) {
        int temp = 0;
        temp = arr[i1];
        arr[i1] = arr[i];
        arr[i] = temp;
    }

    void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void deleteFromHeap() {
        if (size == 0) {
            System.out.println("nothing to delete");
        }

        //step 1: put last element on 1 element
        arr[1] = arr[size];

        //step 2: remove last element
        size--;

        //step 3: take root to its correct position
        int i = 1;
        while (i < size) {
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;
            if (leftIndex < size && arr[i] < arr[leftIndex]) {
                swap(i, leftIndex);
                i = leftIndex;
            } else if (rightIndex < size && arr[i] < arr[rightIndex]) {
                swap(i, rightIndex);
                i = rightIndex;
            } else {
                return;
            }
        }
    }

    //COMPLEXITY OF BUILDING HEAP IS O(N)
    //In heapify, you always remove the root element and then replace it with the last
    //child node and then apply heapify
    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        //check if the current node is maxheap respective, checking the left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        //check if the current node is maxheap respective, checking the right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(largest, i);
            heapify(arr, n, largest);
        }
    }

    void heapSort(int[] arr, int n) {
        int size = n;
        while (size > 1) {
            //Step1: swap(arr[size],arr[1])
            swap(size, 1);
            size--;

            //step2: apply heap sort
            heapify(arr, size, 1);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(54);
        h.insert(52);
        h.print();

        h.deleteFromHeap();

        int[] heapArr = {-1, 54, 53, 55, 52, 50};
        int n = 5;
        for (int i = n / 2; i > 0; i--) {
            h.heapify(heapArr, n, i);
        }
        System.out.println("Heapify");
        for (int i = 1; i < n; i++) {
            System.out.print(heapArr[i] + " ");
        }
        h.print();

        System.out.println("Heap sort");
        h.heapSort(heapArr,n);
        for (int i = 1; i < n; i++) {
            System.out.print(heapArr[i] + " ");
        }
        h.print();
    }

}
