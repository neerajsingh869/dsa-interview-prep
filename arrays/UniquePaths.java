package arrays;

public class UniquePaths {
	
	/*
	 * There is a robot on an m x n grid. The robot is initially located at 
	 * the top-left corner (i.e., grid[0][0]). The robot tries to move to 
	 * the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only 
	 * move either down or right at any point in time.

		Given the two integers m and n, return the number of possible unique paths that 
		the robot can take to reach the bottom-right corner.
		
		The test cases are generated so that the answer will be less than or equal to 2 * 109.
		
		Example 1:
		
		Input: m = 3, n = 7
		Output: 28
		Example 2:
		
		Input: m = 3, n = 2
		Output: 3
		Explanation: From the top-left corner, there are a total of 3 ways to reach the 
		bottom-right corner:
		1. Right -> Down -> Down
		2. Down -> Down -> Right
		3. Down -> Right -> Down
		 
		
		Constraints:
		
		1 <= m, n <= 100
	 */
	// Time complexity -> O(2^(m*n)), Space complexity -> O(m*n)
	public int uniquePaths1(int m, int n) {
        return uniquePaths1(0, 0, m, n);
    }

    private int uniquePaths1(int i, int j, int m, int n) {
        if (i >= m || i < 0 || j < 0 || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        return uniquePaths1(i + 1, j , m , n) + uniquePaths1(i, j + 1, m, n);
    }
    
    // Time complexity -> O(m*n), Space complexity -> O(m*n)
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return uniquePaths2(0, 0, m, n, dp);
    }

    private int uniquePaths2(int i, int j, int m, int n, int[][] dp) {
        if (i >= m || i < 0 || j < 0 || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = (uniquePaths2(i + 1, j , m , n, dp) + 
                            uniquePaths2(i, j + 1, m, n, dp));
    }
    
    // Time complexity -> O(m*n), Space complexity -> O(m*n)
    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }

}
