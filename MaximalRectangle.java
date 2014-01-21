public class Solution {
    public int maximalRectangle(char[][] mx) {
        int m=mx.length;
        if (m==0) return 0;
        int n=mx[0].length;
        int max=0;
        int[][] col=new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                int value = Character.getNumericValue(mx[i][j]);
                if (value==0 || i==0) col[i][j]=value;
                else col[i][j]=value+col[i-1][j];
            }
        }
        for (int i=0;i<m;i++) {
            max=Math.max(max,largestRectangleArea(col[i]));
        }
        return max;
    }
    private int largestRectangleArea(int[] height) {
        Deque<Integer> stack=new ArrayDeque<Integer>();
        int max=0,prev=0;
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
