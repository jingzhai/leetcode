public class Solution {
    public int sqrt(int x) {
        if (x<0) return -1;
        if (x<=1) return x;
        return sqrt(x, 0, x);
    }
    private int sqrt(int x, int s, int e) {
        int m = (s+e)/2;
        if (m>0 && m>x/m) {
            if (m>1 && (m-1)<=x/(m-1)) return m-1;
            else return sqrt(x,s,m-1);
        }
        else if (m>0 && m==x/m) return m;
        else return sqrt(x,m+1,e);
    }
}
