public class Solution {
    public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int carry=1;
        for (int i=digits.length-1;i>=0;i--) {
            if ((digits[i]+carry)<=9) {
                digits[i]++;
                return digits;
            } else if (digits[i]+carry>9) {
                digits[i]=0;
                carry=1;
            }
        }
        if (carry==1) {
            int [] newdigits = new int[digits.length+1];
            newdigits[0]=1;
            for (int i=0;i<digits.length;i++) {
                newdigits[i+1]=digits[i];
            }
            return newdigits;
        } else {
            return digits;
        }
    }
}
