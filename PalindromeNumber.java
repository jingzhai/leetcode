public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (x<0) return false;
        int length=0;
        int temp=x;
        while (temp>0) {
            length++;
            temp=temp/10;
        }
        if (length==0 || length==1) return true;
        for (int i=1;i<=length/2;i++) {
            temp = (int)Math.pow(10,length-2*i+1);
            if (x/temp!=x%10) return false;
            x=(int)(x-((int)x/temp)*temp)/10;
        }
        return true;
    }
}
