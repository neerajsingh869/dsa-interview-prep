package arrays;

public class SetMatrixTo0 {
	
	/*
	 * Given an m x n integer matrix matrix, if an element is 0, 
	 * set its entire row and column to 0's.
	 */
	// Time complexity -> O(m * n * (m + n)), Space complexity -> O(m * n)
	public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        ans[k][j] = 0;
                    }
                    for (int k = 0; k < n; k++) {
                        ans[i][k] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
	
	// Time complexity -> O(m * n), Space complexity -> O(m + n)
	public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;

        int[] rowFlag = new int[m];
        int[] colFlag = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = 1;
                    colFlag[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
                if (rowFlag[i] == 1 || colFlag[j] == 1) {
                	matrix[i][j] = 0;
                }
            }
        }
    }
	
	// Time complexity -> O(m * n), Space complexity -> O(1)
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;

        int col0 = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    
                    if (j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // order is important (col0 is checked later)
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }    
    }

}
