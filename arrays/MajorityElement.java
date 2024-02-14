package arrays;

import java.util.HashMap;

public class MajorityElement {
	
	/*
	 * Given an array nums of size n, return the majority element.

		The majority element is the element that appears more than ⌊n / 2⌋ times. 
		You may assume that the majority element always exists in the array.
		
		 
		
		Example 1:
		
		Input: nums = [3,2,3]
		Output: 3
		Example 2:
		
		Input: nums = [2,2,1,1,1,2,2]
		Output: 2
		 
		
		Constraints:
		
		n == nums.length
		1 <= n <= 5 * 104
		-109 <= nums[i] <= 109
		 
		
		Follow-up: Could you solve the problem in linear time and in O(1) space?
	 */
	
	// Time complexity -> O(n * n), Space complexity -> O(1)
	public int majorityElement1(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int freq = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                }
            }

            if (freq > n / 2) {
                return nums[i];
            }
        }
        
        // returning -1 in case there is no major element
        return -1;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int majorityElement2(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > n / 2) {
                return num;
            }
        }
        
        return -1;
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public int majorityElement3(int[] nums) {
        int n = nums.length;
        int count = 0;
        int majorElement = 0;

        // applying algorithm
        for (int num : nums) {
            if (count == 0) {
                count = 1;
                majorElement = num;
            } else if (majorElement == num) {
                count++;
            } else {
                count--;
            }
        }

        // verifying if element is major element
        count = 0;
        for (int num : nums) {
            if (num == majorElement) count++;
        }
        
        return (count > n / 2) ? majorElement : -1;
    }

}
