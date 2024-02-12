package arrays;

public class BestTimeToBuyAndSell {
	
	/*
	 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

		You want to maximize your profit by choosing a single day to buy one stock and choosing 
		a different day in the future to sell that stock.
		
		Return the maximum profit you can achieve from this transaction. If you cannot achieve 
		any profit, return 0.
		
		 
		
		Example 1:
		
		Input: prices = [7,1,5,3,6,4]
		Output: 5
		Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
		Note that buying on day 2 and selling on day 1 is not allowed because you must 
		buy before you sell.
		Example 2:
		
		Input: prices = [7,6,4,3,1]
		Output: 0
		Explanation: In this case, no transactions are done and the max profit = 0.
		 
		
		Constraints:
		
		1 <= prices.length <= 105
		0 <= prices[i] <= 104
	 */
	// Time complexity -> O(n * n), Space complexity -> O(1)
	public int maxProfit1(int[] prices) {
        int n = prices.length;

        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            int tempMax = prices[i + 1];
            for (int j = i + 1; j < n; j++) {
                tempMax = Math.max(tempMax, prices[j]);
            }

            maxProfit = Math.max(maxProfit, tempMax - prices[i]);
        }

        return maxProfit;
    }
	
	// Time complexity -> O(n * n), Space complexity -> O(1)
	public int maxProfit2(int[] prices) {
        int n = prices.length;

        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
        	for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i]) {
                	maxProfit = Math.max(prices[j] - prices[i], maxProfit);
                }
            }
        }

        return maxProfit;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int maxProfit3(int[] prices) {
        int n = prices.length;
        
        int[] sellingPoints = new int[n];
        int maxTillNowIdx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (prices[maxTillNowIdx] <= prices[i]) {
                maxTillNowIdx = i;
            }
            sellingPoints[i] = maxTillNowIdx;
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, prices[sellingPoints[i]] - prices[i]);
        }

        return maxProfit;
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public int maxProfit4(int[] prices) {
        int n = prices.length;
        
        int maxProfit = 0;
        int maxTillNowIdx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (prices[maxTillNowIdx] <= prices[i]) {
                maxTillNowIdx = i;
            }
            maxProfit = Math.max(maxProfit, prices[maxTillNowIdx] - prices[i]);
        }

        return maxProfit;
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public int maxProfit5(int[] prices) {
        int n = prices.length;
        
        int maxProfit = 0;
        int maxSellPrice = prices[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxSellPrice = Math.max(maxSellPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxSellPrice - prices[i]);
        }

        return maxProfit;
    }

}
