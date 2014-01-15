public class Solution {
    public double pow(double x, int n) {
        if (n==0) return 1;
        boolean positive=true;
        if (n<0) {
            positive=false;
            n=0-n;
        }
        double result=0;
        if (n%2==0) {
            double half=pow(x, n/2);
            result = half*half;
        } else {
            double half=pow(x, (n-1)/2);
            result = half*half*x;
        }
        return positive?result:1/result;
    }
}
