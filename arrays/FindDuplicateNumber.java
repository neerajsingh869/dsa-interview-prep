package arrays;

import java.util.Arrays;

public class FindDuplicateNumber {
	
	/*
	 * Given an array of integers nums containing n + 1 integers where each 
	 * integer is in the range [1, n] inclusive.

		There is only one repeated number in nums, return this repeated number.
		
		You must solve the problem without modifying the array nums and uses only constant extra space.
		
		 
		
		Example 1:
		
		Input: nums = [1,3,4,2,2]
		Output: 2
		Example 2:
		
		Input: nums = [3,1,3,4,2]
		Output: 3
		 
		
		Constraints:
		
		1 <= n <= 105
		nums.length == n + 1
		1 <= nums[i] <= n
		All the integers in nums appear only once except for precisely one integer 
		which appears two or more times.
		 
		
		Follow up:
		
		How can we prove that at least one duplicate number must exist in nums?
		Can you solve the problem in linear runtime complexity?
	 */
	// Time complexity -> O(n * log(n)), Space complexity -> O(1)
	public int findDuplicate1(int[] nums) {
		int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
	
	// Time complexity -> O(n * n), Space complexity -> O(1)
	public int findDuplicate2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return nums[0];
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public int findDuplicate3(int[] nums) {
        int n = nums.length;
        int sum = (n * (n - 1)) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }


        return actualSum - sum;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int findDuplicate4(int[] nums) {
        int n = nums.length;
        
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            if (freq[nums[i]] == 0) {
                freq[nums[i]]++;
            } else {
                return nums[i];
            }
        }

        return nums[0];
    }

}
