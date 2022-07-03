package common;

public class PivotIndex {
    /*
    Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;

        int i = 0;
        while(i < nums.length) {
            totalSum += nums[i];
            i++;
        }

        i = 0;
        while(i < nums.length) {
            if(totalSum - nums[i] == leftSum) {
                return i;
            } else {
                leftSum += nums[i];
                totalSum -= nums[i];
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {-1, -1, -1, -1, -1, 0};
        PivotIndex pvot = new PivotIndex();
        System.out.println("Ans: " + pvot.pivotIndex(arr));
    }
}
