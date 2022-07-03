package common;

public class RunningSumOfArray {
    /*
    Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     */
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=nums[i];
            ans[i]=sum;
        }
        return ans;
    }
}
