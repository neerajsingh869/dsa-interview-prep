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
	
	// Time complexity -> O(m * n), Space complexity -> O(m * n)
	public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int[] flatArr = new int[m * n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flatArr[k++] = matrix[i][j];
            }
        }

        return binarySearch(flatArr, target);
    }
	
	// Time complexity -> O(m * log(n)), Space complexity -> O(1)
	public boolean searchMatrix3(int[][] matrix, int target) {
       int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (binarySearch(matrix[i], target) == true) {
                return true;
            }
        }

        return false; 
    }
	
	// Time complexity -> O(m * log(n)), Space complexity -> O(1)
	public boolean searchMatrix4(int[][] matrix, int target) {
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
    
    // Time complexity -> O(log(m) * log(n)), Space complexity -> O(1)
    public boolean searchMatrix5(int[][] matrix, int target) {
        int m = matrix.length;
         if (m == 0) return false;
         int n = matrix[0].length;

         int rowLow = 0, rowHigh = m - 1;
         while (rowLow <= rowHigh) {
             int mid = rowLow + (rowHigh - rowLow) / 2;
             if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                 return binarySearch(matrix[mid], target);
             } else if (matrix[mid][n - 1] <= target) {
                 rowLow = mid + 1;
             } else {
                 rowHigh = mid - 1;
             }
         }

         return false; 
     }
    
    // Time complexity -> O(log(m * n)), Space complexity -> O(1)
    public boolean searchMatrix6(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int i = 0, j = m * n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int rowIdx = mid / n;
            int colIdx = mid % n;

            if (matrix[rowIdx][colIdx] == target) {
                return true;
            } else if (matrix[rowIdx][colIdx] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return false;
    }
    
    

}
