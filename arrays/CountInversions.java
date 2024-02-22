package arrays;

public class CountInversions {
	
	/*
	 * For a given integer array/list 'ARR' of size 'N' containing all distinct values, 
	 * find the total number of 'Inversions' that may exist.

		An inversion is defined for a pair of integers in the array/list when the following 
		two conditions are met.
		
		A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:
		
		1. 'ARR[i] > 'ARR[j]' 
		2. 'i' < 'j'
		
		Where 'i' and 'j' denote the indices ranging from [0, 'N').
		Detailed explanation ( Input/output format, Notes, Images )
		Constraints :
		1 <= N <= 10^5 
		1 <= ARR[i] <= 10^9
		
		Where 'ARR[i]' denotes the array element at 'ith' index.
		
		Time Limit: 1 sec
		Sample Input 1 :
		3
		3 2 1
		Sample Output 1 :
		3
		Explanation of Sample Output 1:
		We have a total of 3 pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).
		Sample Input 2 :
		5
		2 5 1 3 4
		Sample Output 2 :
		4
		Explanation of Sample Output 1:
		We have a total of 4 pairs which satisfy the condition of inversion. (2, 1), (5, 1), (5, 3) and (5, 4).
	 */
	// Time complexity -> O(n*n)
	public static long getInversions1(long arr[], int n) {
        int countInversions = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    countInversions++;
                }
            }
        }

        return countInversions;
    }
	
	private static long merge(long arr[], int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        long invCount = 0;
        long temp[] = new long[(right - left + 1)];

        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                ++k;
                ++i;
            } 
            else {
                temp[k] = arr[j];
                invCount += (mid - i);
                ++k;
                ++j;
            }
        }

        while (i < mid) {
            temp[k] = arr[i];
            ++k;
            ++i;
        }

        while (j <= right) {
            temp[k] = arr[j];
            ++k;
            ++j;
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    // Function to split two subarrays and then merge them and count inversions.
    private static long mergeSort(long arr[], int left, int right) {
        long invCount = 0;

        if (right > left) {
            int mid = (right + left) / 2;

            /* 
                Divide the array into two parts
                total inversion count will be the
                sum of 'INVCOUNT' of left part +
                'INVCOUNT' of right part + 'INVCOUNT' of
                their combined part.
            */
            invCount = mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid + 1, right);

            // Merge both parts and count their combined inversions.
            invCount += merge(arr, left, mid + 1, right);
        }
        return invCount;
    }
    
    // Time complexity -> O(n*log(n))
    public static long getInversions2(long arr[], int n) {
        return mergeSort(arr, 0, n - 1);
    }

}
