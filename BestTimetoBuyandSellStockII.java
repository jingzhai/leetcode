public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (prices.length<=1) return 0;
        int profit=0, start=0, index=1;

        while(index<prices.length) {
            while (index<prices.length && prices[index]>=prices[index-1]) {
                index++;
            }
            if(start!=index-1) {
                profit+=prices[index-1]-prices[start];
            } 
            start=index;
            index++;
        }
        return profit;
    }
}
