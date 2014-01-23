public class Solution {
    public int divide(int a, int b) { //a/b
        boolean negative = (a>0)^(b>0);
        long al = Math.abs((long)a);
        long bl = Math.abs((long)b);
        if (al==bl) return negative?-1:1;
        ArrayList<Long> list = new ArrayList<Long>();
        long r=bl;
        while (r<al) {
            list.add(r);
            r=r<<1;
        }
        int result=0, cur=list.size()-1;
        while (al>0 && cur>=0) {
            if (al>=list.get(cur)) {
                al-=list.get(cur);
                result+=1<<cur;
            } else cur--;
        }
        return negative?-result:result;
    }
}
