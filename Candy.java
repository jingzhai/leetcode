public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length==0) return 0;
        int[] child = new int[ratings.length];
        for (int i=0;i<ratings.length;i++) {
            child[i]=1;
        }
        for (int i=1;i<ratings.length;i++) {
            if (ratings[i]>ratings[i-1]) child[i]=child[i-1]+1;
        }
        for (int i=ratings.length-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1] && child[i]<=child[i+1]) child[i]=child[i+1]+1;
        }
        int res=0;
        for (int i=0;i<child.length;i++) {
            res+=child[i];
        }
        return res;
    }
}
