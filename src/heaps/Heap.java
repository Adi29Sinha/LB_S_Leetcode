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

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(54);
        h.insert(52);
        h.print();

        h.deleteFromHeap();
        h.print();
    }

}
