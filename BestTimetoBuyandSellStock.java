public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int max = 0;
        int[] lmin = new int[prices.length];
        int[] rmax = new int[prices.length];
        if (prices.length==0) return 0;
        lmin[0]=prices[0];
        for (int i=1;i<prices.length;i++) {
            lmin[i] = Math.min(prices[i],lmin[i-1]);
        }   
        rmax[prices.length-1]=prices[prices.length-1];
        for (int j=prices.length-2;j>=0;j--) {
            rmax[j] = Math.max(prices[j],rmax[j+1]);
        }  
        for (int k=0;k<prices.length;k++) {
            if (max<rmax[k]-lmin[k]) {
                max=rmax[k]-lmin[k];
            }
        }
        return max;
    }
}
