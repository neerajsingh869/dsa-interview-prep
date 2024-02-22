package arrays;

public class SearchIn2dMatrix {
	
	/*
	 * You are given an m x n integer matrix matrix with the following two properties:

		Each row is sorted in non-decreasing order.
		The first integer of each row is greater than the last integer of the previous row.
		Given an integer target, return true if target is in matrix or false otherwise.
		
		You must write a solution in O(log(m * n)) time complexity.
		
		Example 1:
		
		Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
		Output: true
		Example 2:
		
		Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
		Output: false
		
		Constraints:
		
		m == matrix.length
		n == matrix[i].length
		1 <= m, n <= 100
		-104 <= matrix[i][j], target <= 104
	 */
	// Time complexity -> O(m * n), Space complexity -> O(1)
	public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
	
	// Time complexity -> O(m * log(n)), Space complexity -> O(1)
	public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int rowIdx = 0;

        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                rowIdx = i;
                break;
            }
        }

        return binarySearch(matrix[rowIdx], target);
    }
	
    private boolean binarySearch(int[] arr, int target) {
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        
        return false;
    }

}
