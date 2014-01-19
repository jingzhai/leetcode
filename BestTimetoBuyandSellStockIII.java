public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int[] leftmax=new int[prices.length];
        int[] rightmax=new int[prices.length];
        leftmax[0]=0;
        rightmax[0]=0;
        rightmax[prices.length-1]=0;

        int lmin=Integer.MAX_VALUE;
        for (int i=1;i<prices.length;i++) {
            lmin=Math.min(lmin,prices[i-1]);
            leftmax[i]=Math.max(prices[i]-lmin,leftmax[i-1]);
        }
        int rmax=Integer.MIN_VALUE;
        for (int j=prices.length-2;j>0;j--) {
            rmax=Math.max(rmax,prices[j+1]);
            rightmax[j]=Math.max(rmax-prices[j],rightmax[j+1]);
        }
        int max=0;
        for (int i=1;i<prices.length;i++) {
            max=Math.max(leftmax[i-1]+rightmax[i],max);
        }
        max=Math.max(max,leftmax[prices.length-1]);
        return max;
    }
}
