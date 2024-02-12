package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTraingle {
	
	/*
	 * Given an integer numRows, return the first numRows of Pascal's triangle.
	 */
	// Time complexity -> O(numRows * numRows), Space complexity -> O(numRows * numRows)
	public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return null;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> iMinus1thRow = ans.get(i - 1);
            List<Integer> ithRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ithRow.add(1);
                } else {
                    ithRow.add(iMinus1thRow.get(j - 1) + iMinus1thRow.get(j));
                }
            }
            ans.add(ithRow);
        }

        return ans;
    }

}
