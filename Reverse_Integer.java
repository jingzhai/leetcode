public class Solution {
    public int reverse(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        char[] c = new Integer(x).toString().toCharArray();
        if (c.length<=1) return x;
        int front=0;
        int back=c.length-1;
        boolean neg = false;
        if (c[front]=='-') {
            neg = true;
            front++;
        }
        while (c[front]=='0'){ 
            front++;
        } 
        int index = front;
        while (front<back) {
            char temp = c[front];
            c[front] = c[back];
            c[back] = temp;
            front++;
            back--;
        }
        int rev = Integer.parseInt(new String(c).substring(index));
        if (neg) rev = 0-rev;
        return rev;
    }
}
