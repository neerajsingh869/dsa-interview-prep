package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LongestConsecutiveSequence {
	
	/*
	 * Given an unsorted array of integers nums, return the length of the longest 
	 * consecutive elements sequence.

		You must write an algorithm that runs in O(n) time.
		
		 
		
		Example 1:
		
		Input: nums = [100,4,200,1,3,2]
		Output: 4
		Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
		Therefore its length is 4.
		Example 2:
		
		Input: nums = [0,3,7,2,5,8,4,6,0,1]
		Output: 9
		 
		
		Constraints:
		
		0 <= nums.length <= 105
		-109 <= nums[i] <= 109
	 */
	
	// Time complexity -> O(n*log(n))
	public int longestConsecutive2(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        Arrays.sort(nums); 

        // find max length of consecutive sequence
        int maxLength = 1;
        int length = 1;
        int lastSmaller = nums[0];
        for (int i = 1; i < n; i++) {
            // in case of duplicate, skip current iteration
            if (nums[i] == lastSmaller) {
                continue;
            }

            if (nums[i] == lastSmaller + 1) {
                length++;
            } else {
                length = 1;
            }

            lastSmaller = nums[i];

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int longestConsecutive3(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        // remove duplicates by using set
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // find max length of consecutive sequence
        int maxLength = 1;
        for (int it : set) {
        	// on avg, contains method takes O(1) time
            if (!set.contains(it - 1)) {
                int x = it;
                int length = 0;
                while (set.contains(x)) {
                    x++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }

        }

        return maxLength;
    }

}
