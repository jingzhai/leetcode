public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length<=1) return;
        int n=num.length-2;

        while (n>=0&&num[n]>=num[n+1]) {
            n--;
        }
        if (n<0) {
            Arrays.sort(num);
            return;
        }
        int minGTn=Integer.MAX_VALUE;
        int minGTnLoc=-1;
        for (int i=n+1;i<num.length;i++) {
            if (num[i]<minGTn && num[i]>num[n]) {
                minGTn=num[i];
                minGTnLoc=i;
            }
        }
        num[minGTnLoc]=num[n];
        num[n]=minGTn;
        Arrays.sort(num,n+1,num.length);
    }
}
