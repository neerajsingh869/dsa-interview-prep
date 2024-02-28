package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
	
	/*
	 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

		Example 1:
		
		Input: nums = [3,2,3]
		Output: [3]
		Example 2:
		
		Input: nums = [1]
		Output: [1]
		Example 3:
		
		Input: nums = [1,2]
		Output: [1,2]
		 
		
		Constraints:
		
		1 <= nums.length <= 5 * 104
		-109 <= nums[i] <= 109
		 
		
		Follow up: Could you solve the problem in linear time and in O(1) space?
	 */
	// Time complexity -> O(n*n)
	public List<Integer> majorityElement1(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 3) {
                if (!ans.contains(nums[i])) {
                    ans.add(nums[i]);
                }
            }
            
            if (ans.size() == 2) {
                break;
            }
        }

        return ans;    
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public List<Integer> majorityElement2(int[] nums) {
		List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            if (freqMap.get(num) > n / 3) {
                ans.add(num);
            }

            if (ans.size() == 2) {
                break;
            }
        }

        return ans;  
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && element2 != nums[i]) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0 && element1 != nums[i]) {
                count2 = 1;
                element2 = nums[i];
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (element1 == nums[i]) count1++;
            if (element2 == nums[i]) count2++;
        }

        if (count1 > nums.length / 3) {
            ans.add(element1);
        }
        if (count2 > nums.length / 3) {
            ans.add(element2);
        }

        return ans;
    }

}
