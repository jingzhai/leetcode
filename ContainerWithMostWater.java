public class Solution {
    public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int max = 0;
        for (int i=0,j=height.length-1;i<height.length&&j>=i;) {
            int value = Math.min(height[j],height[i])*(j-i);
            if (max<value) {
                max=value;
            }
            if (height[i]>height[j]) j--;
            else i++;
        }
        return max;
    }
}
