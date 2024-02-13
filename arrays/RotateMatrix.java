package arrays;

public class RotateMatrix {
	
	/*
	 * You are given an n x n 2D matrix representing an image, rotate the 
	 * image by 90 degrees (clockwise).

		You have to rotate the image in-place, which means you have to modify the 
		input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
		
		
		Example 1:
		
		Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
		Output: [[7,4,1],[8,5,2],[9,6,3]]
		Example 2:
		
		Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
		Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
		 
		
		Constraints:
		
		n == matrix.length == matrix[i].length
		1 <= n <= 20
		-1000 <= matrix[i][j] <= 1000
	 */
	// Time complexity -> O(n * n), Space complexity -> O(n * n)
	public void rotate1(int[][] matrix) {
        int n = matrix.length;

        int[][] dummyMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dummyMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = dummyMatrix[i][j];
            }
        }    
    }
	
	// Time complexity -> O(n * n), Space complexity -> O(1)
	public void rotate2(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
	
	// Time complexity -> O(n * n), Space complexity -> O(1)
	public void rotate(int[][] matrix) {
        int n = matrix.length;

        // step 1: transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // step 2: reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

}
