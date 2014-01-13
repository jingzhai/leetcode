public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int diff=Integer.MAX_VALUE;
        int sum=0;
        Arrays.sort(num);
        for (int i=0;i<num.length;i++) {
            for (int j=i+1,k=num.length-1;j<k;) {
                int temp = num[i]+num[j]+num[k];
                int currDiff = Math.abs(temp-target);
                if (currDiff==0) return temp;
                if (currDiff<diff) {
                    diff=currDiff;
                    sum=temp;
                }
                if (temp<target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}
