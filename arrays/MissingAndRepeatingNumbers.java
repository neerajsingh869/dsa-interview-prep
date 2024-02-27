package arrays;

import java.util.ArrayList;

public class MissingAndRepeatingNumbers {
	
	/*
	 * You are given an array of size ‘N’. The elements of the array are 
	 * in the range from 1 to ‘N’.

		Ideally, the array should contain elements from 1 to ‘N’. But due to some 
		miscalculations, there is a number R in the range [1, N] which appears in 
		the array twice and another number M in the range [1, N] which is missing 
		from the array.
		
		Your task is to find the missing number (M) and the repeating number (R).
		
		For example:
		Consider an array of size six. The elements of the array are { 6, 4, 3, 5, 5, 1 }. 
		The array should contain elements from one to six. Here, 2 is not present 
		and 5 is occurring twice. Thus, 2 is the missing number (M) and 5 is the 
		repeating number (R). 
		Follow Up
		Can you do this in linear time and constant additional space? 
		Detailed explanation ( Input/output format, Notes, Images )
		Constraints:
		2 <= N <= 5 * 10^4
		1 <= data <= N
		
		Where ‘N’ is the size of the array and ‘data’ denotes the value of the 
		elements of the array. 
	 */
	// Time complexity -> O(n*n)
	public static int[] missingAndRepeating1(ArrayList<Integer> arr, int n) {
        // code fragment to find repeating number
        int r = arr.get(0);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    r = arr.get(i);
                    break;
                }
            }
        }

        // code fragment to find missing number
        int m = arr.get(0);
        for (int i = 0; i < n; i++) {
            boolean isFound = false;

            for (int j = 0; j < n; j++) {
                if (i + 1 == arr.get(j)) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                m = i + 1;
                break;
            }
        }

        int[] ans = {m, r};
        return ans;
    }
	
	// Time complexity -> O(n*n)
	public static int[] missingAndRepeating2(ArrayList<Integer> arr, int n) {
        int r = arr.get(0);
        int m = arr.get(0);

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr.get(j) == i + 1) {
                    count++;
                }
            }

            if (count == 2) {
                r = i + 1;
            } else if (count == 0) {
                m = i + 1;
            }
        }

        int[] ans = {m, r};
        return ans;
    }
	
	// Time complexity -> O(n)
	public static int[] missingAndRepeating3(ArrayList<Integer> arr, int n) {
        int r = arr.get(0);
        int m = arr.get(0);

        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[arr.get(i)]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                r = i;
            } else if (hash[i] == 0) {
                m = i;
            }
        }

        int[] ans = {m, r};
        return ans;
    }

}
