package binarySearch;

public class SearchInsertPosition {
    /*
    Input: nums = [1,3,5,6], target = 5
    Output: 2

    Input: nums = [1,3,5,6], target = 7
    Output: 4
     */
    int searchInsert(int[] nums, int target) {
        int st = 0;
        int len = nums.length;
        int end = len - 1;
        int mid = 0;
        while (st <= end) {
            mid = (st + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    public static void main(String[] args) {
        SearchInsertPosition position = new SearchInsertPosition();
        int[] arr = {1, 3, 5, 6};
        int target = 2;
        System.out.println("Position: " + position.searchInsert(arr, target));
    }
}
