/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Slope {
    int a;
    int b;
    Slope(int a, int b) {
        this.a=a;
        this.b=b;
    }
    public int hashCode() {
        return (a==0)?Integer.MAX_VALUE:b/a;
    }
    public boolean equals(Object obj) {
        Slope s = (Slope)obj;
        return ((this.a==0 && a==0)||(this.b==0 && b==0)||(this.a*s.b==this.b*s.a));
    }
}
public class Solution {
    public int maxPoints(Point[] points) {
        int n=points.length;
        if (n<=1) return n;
        int max=1;
        HashMap<Slope, Integer> map = new HashMap<Slope, Integer>();
        for (int i=0;i<n;i++) {
            map.clear();
            Point p1=points[i];
            int curmax=1;
            int dup=0;
            for (int j=i+1;j<n;j++) {
                Point p2=points[j];
                if (p1.x==p2.x&&p1.y==p2.y) {
                    dup++;
                    continue;
                }
                Slope slope = new Slope(p1.x-p2.x,p1.y-p2.y);
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope)+1);
                } else {
                    map.put(slope,2);
                }
                if (map.get(slope)>curmax) curmax=map.get(slope);
            }
            if (max<curmax+dup) max=curmax+dup;
        }
        return max;
    }
}
