package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	
	/*
	 * Given an array nums of n integers, return an array of all the unique 
	 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

		0 <= a, b, c, d < n
		a, b, c, and d are distinct.
		nums[a] + nums[b] + nums[c] + nums[d] == target
		You may return the answer in any order.
		
		 
		
		Example 1:
		
		Input: nums = [1,0,-1,0,-2,2], target = 0
		Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		Example 2:
		
		Input: nums = [2,2,2,2,2], target = 8
		Output: [[2,2,2,2]]
		 
		
		Constraints:
		
		1 <= nums.length <= 200
		-109 <= nums[i] <= 109
		-109 <= target <= 109
	 */
	// Time complexity -> O(n^4)
	public List<List<Integer>> fourSum1(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long)nums[i];
                        sum += nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], 
                                                                nums[j],
                                                                    nums[k],
                                                                        nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;    
    }
	
	// Time complexity -> O(n^3)
	public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
	
    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }
        
        if (k == 2) {
            return twoSum(nums, target, start);
        }
    
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
    
        return res;
    }
	
    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
    
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                lo++;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }
                                                          
        return res;
    }

}
