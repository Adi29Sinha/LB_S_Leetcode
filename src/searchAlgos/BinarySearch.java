package searchAlgos;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0 , end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
        /*
        class Solution {
  public int search(int[] nums, int target) {
    int pivot, left = 0, right = nums.length - 1;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (nums[pivot] == target) return pivot;
      if (target < nums[pivot]) right = pivot - 1;
      else left = pivot + 1;
    }
    return -1;
  }
}
         */
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int arr[] = { 5};
        int pos = bs.search(arr, 5);
        System.out.println(pos);
    }
}
