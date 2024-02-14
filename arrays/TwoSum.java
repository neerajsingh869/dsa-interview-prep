package arrays;

import java.util.HashMap;

public class TwoSum {
	
	/*
	 * Given an array of integers nums and an integer target, return indices of the 
	 * two numbers such that they add up to target.

		You may assume that each input would have exactly one solution, and you may not use 
		the same element twice.
		
		You can return the answer in any order.
		
		 
		
		Example 1:
		
		Input: nums = [2,7,11,15], target = 9
		Output: [0,1]
		Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
		Example 2:
		
		Input: nums = [3,2,4], target = 6
		Output: [1,2]
		Example 3:
		
		Input: nums = [3,3], target = 6
		Output: [0,1]
		 
		
		Constraints:
		
		2 <= nums.length <= 104
		-109 <= nums[i] <= 109
		-109 <= target <= 109
		Only one valid answer exists.
		 
		
		Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
	 */
	
	// Time complexity -> O(n * n), Space complexity -> O(1)
	public int[] twoSum1(int[] nums, int target) {
		int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        
        // can't iterate in hashmap, as duplicate values indices
        // will be overwritten in hashmap
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i]) && 
                map.get(target - nums[i]) != i) {
                    ans[0] = i;
                    ans[1] = map.get(target - nums[i]);
                    return ans;
                }
        }

        return ans;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int[] twoSum3(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }

        return ans;
    }

}
