package arrays;

public class PowXN {
	
	/*
	 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

		Example 1:
		
		Input: x = 2.00000, n = 10
		Output: 1024.00000
		Example 2:
		
		Input: x = 2.10000, n = 3
		Output: 9.26100
		Example 3:
		
		Input: x = 2.00000, n = -2
		Output: 0.25000
		Explanation: 2-2 = 1/22 = 1/4 = 0.25
		 
		
		Constraints:
		
		-100.0 < x < 100.0
		-231 <= n <= 231-1
		n is an integer.
		Either x is not zero or n > 0.
		-104 <= xn <= 104
	 */
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public double myPow1(double x, int n) {
        double ans = 1.0;

        for (int i = 0; i < Math.abs(n); i++) {
            ans *= x;
        }
        
        return (n >= 0) ? ans : 1 / ans;
    }
	
	// Time complexity -> O(log(n)), Space complexity -> O(1)
	public double myPow2(double x, int n) {
        return Math.pow(x, n);
    }
	
	// Time complexity -> O(log(n)), Space complexity -> O(1)
	public double myPow(double x, int n) {
        double ans = 1.0;
        long m = n;
        if (m < 0) m = -1 * m;

        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * x;
                m = m - 1;
            } else {
                x = x * x;
                m = m / 2;
            }
        }
        
        return (n < 0) ? 1 / ans : ans;
    }

}
