package arrays;

public class NextPermutation {
	
	public void nextPermutation(int[] nums) {
        int n = nums.length;
        // [same as previous] + [arr[break-point]] + [right part]

        // step 1: find break point 
        int breakPoint = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }  

        // step 2: check if breakPoint doesn't exist
        if (breakPoint == -1) {
            reverseArray(nums, 0, n - 1);
        } else {
            // step 3: in case breakPoint exist, find next permuation
            /* 
                step 3.1: find element index in right part just
                            greater than element at breakPoint
            */
            int nextGreaterEleIdx = breakPoint + 1;
            for (int i = breakPoint + 1; i < n; i++) {
                if (nums[breakPoint] >= nums[i]) {
                    break;
                }
                nextGreaterEleIdx = i;
            }

            // step 3.2: swap elements
            swap(nums, breakPoint, nextGreaterEleIdx);

            // step 3.3: reverse right part
            reverseArray(nums, breakPoint + 1, n - 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverseArray(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

}
