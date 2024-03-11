package arrays;

public class ReversePairs {
	
	/*
	 * Given an integer array nums, return the number of reverse pairs in the array.

		A reverse pair is a pair (i, j) where:
		
		0 <= i < j < nums.length and
		nums[i] > 2 * nums[j].
		 
		
		Example 1:
		
		Input: nums = [1,3,2,3,1]
		Output: 2
		Explanation: The reverse pairs are:
		(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
		(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
		Example 2:
		
		Input: nums = [2,4,3,5,1]
		Output: 3
		Explanation: The reverse pairs are:
		(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
		(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
		(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
		 
		
		Constraints:
		
		1 <= nums.length <= 5 * 104
		-231 <= nums[i] <= 231 - 1
	 */
	// Time complexity -> O(n^2), Space complexity -> O(1)
	public int reversePairs1(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long num1 = nums[i];
                long num2 = nums[j];
                if (num1 > 2 * num2) {
                    count++;
                }
            }
        }

        return count;
    }
	
	// Time complexity -> O(n * log(n)), Space complexity -> O(n)
	public int reversePairs2(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int st, int end) {
        if (st >= end) return 0;

        int count = 0;

        int mid = st + (end - st) / 2;

        count += mergeSort(nums, st, mid);
        count += mergeSort(nums, mid + 1, end);

        count += countReversePairs(nums, st, mid, end);

        merge(nums, st, mid, end);

        return count;
    }

    private int countReversePairs(int[] nums, int st, int mid, int end) {
        int count = 0;
        int j = mid + 1;

        for (int i = st; i <= mid; i++) {
            while (j <= end && nums[i] > (long) 2 * nums[j]) {
                j++;
            }

            count += (j - mid - 1);
        }

        return count;
    }

    private void merge(int[] nums, int st, int mid, int end) {
        int[] tempArr = new int[end - st + 1];
        int k = 0;
        int i = st;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] >= nums[j]) {
                tempArr[k++] = nums[j++];
            } else {
                tempArr[k++] = nums[i++];
            }
        }

        while (i <= mid) {
            tempArr[k++] = nums[i++];
        }

        while (j <= end) {
            tempArr[k++] = nums[j++];
        }

        for (int l = st; l <= end; l++) {
            nums[l] = tempArr[l - st];
        }
    }

}
