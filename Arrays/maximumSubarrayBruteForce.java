package Arrays;

public class maximumSubarrayBruteForce {
    public int maxSubArray(int[] nums) {
        int a_ptr = 0, b_ptr = 0, sum = 0, ans = Integer.MIN_VALUE;
        while (a_ptr < nums.length) {
            sum += nums[b_ptr];
            ans = Math.max(ans, sum);
            b_ptr++;
            if (b_ptr == nums.length) {
                a_ptr++;
                b_ptr = a_ptr;
                sum = 0;
            }
        }
        return ans;
    }    
}
