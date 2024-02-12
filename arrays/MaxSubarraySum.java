package arrays;

public class MaxSubarraySum {
	
	/*
	 * Given an integer array nums, find the subarray
 		with the largest sum, and return its sum.
	 */
	// Time complexity -> O(n * n * n), Space complexity -> O(1)
	public int maxSubArray1(int[] nums) {
        int n = nums.length;

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tempSum = 0;

                for (int k = i; k <= j; k++) {
                    tempSum += nums[k];
                }

                if (tempSum > maxSum) {
                    maxSum = tempSum;
                }
            }
        }

        return maxSum;
    }
	
	// Time complexity -> O(n * n), Space complexity -> O(1)
	public int maxSubArray2(int[] nums) {
        int n = nums.length;

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tempSum = 0;
            for (int j = i; j < n; j++) {
                tempSum += nums[j];

                if (tempSum > maxSum) {
                    maxSum = tempSum;
                }
            }
        }

        return maxSum;
    }

}
