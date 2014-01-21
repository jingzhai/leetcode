public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack=new Stack<Integer>();
        int max=0;
        for (int i=0;i<=height.length;i++) {
            if (stack.isEmpty() || (i<height.length && height[i]>=height[stack.peek()])) {
                stack.push(i);
            } else {
                int cur=stack.pop();
                int width=(stack.isEmpty())?i:(i-stack.peek()-1);
                max=Math.max(max,height[cur]*width);
                if (i < height.length || !stack.isEmpty()) i--;
            }
        }
        return max;
    }
}
