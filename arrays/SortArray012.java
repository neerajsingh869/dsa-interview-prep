package arrays;

public class SortArray012 {
	
	/*
	 * Given an array nums with n objects colored red, white, or blue, 
	 * sort them in-place so that objects of the same color are adjacent, 
	 * with the colors in the order red, white, and blue.

		We will use the integers 0, 1, and 2 to represent the color red, white, 
		and blue, respectively.
		
		You must solve this problem without using the library's sort function.
		
		 
		
		Example 1:
		
		Input: nums = [2,0,2,1,1,0]
		Output: [0,0,1,1,2,2]
		Example 2:
		
		Input: nums = [2,0,1]
		Output: [0,1,2]
		 
		
		Constraints:
		
		n == nums.length
		1 <= n <= 300
		nums[i] is either 0, 1, or 2.
		 
		
		Follow up: Could you come up with a one-pass algorithm using only constant 
		extra space?
	 */
	
	// Brute force -> Apply any sorting algorithm
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public void sortColors1(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public void sortColors2(int[] nums) {
        int next0 = 0;
        int curr = 0;
        int next2 = nums.length - 1;

        while (curr <= next2) {
            if (nums[curr] == 0) {
                int temp = nums[next0];
                nums[next0] = nums[curr];
                nums[curr] = temp;
                next0++;
                curr++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                int temp = nums[next2];
                nums[next2] = nums[curr];
                nums[curr] = temp;
                next2--;
            }
        }    
    }

}
