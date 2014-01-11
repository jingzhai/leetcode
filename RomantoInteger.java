public class Solution {
    public int romanToInt(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int sum=0;
        if (s==null) return 0;
        char[] chars = s.toCharArray();
        int i=0;
        while (i<chars.length) {
            
            if (chars[i]=='M') {
                sum+=1000;
                i++;
            }
            else if (chars[i]=='D') {
                sum+=500;
                i++;
            }
            else if (chars[i]=='C') {
                if (i<chars.length-1 && chars[i+1]=='D') {
                    sum+=400;
                    i+=2;
                } else if (i<chars.length-1 && chars[i+1]=='M') {
                    sum+=900;
                    i+=2;
                } else {
                    sum+=100;
                    i++;
                }
            }
            else if (chars[i]=='L') {
                sum+=50;
                i++;
            }
            else if (chars[i]=='X') {
                if (i<chars.length-1 && chars[i+1]=='L') {
                    sum+=40;
                    i+=2;
                } else if (i<chars.length-1 && chars[i+1]=='C') {
                    sum+=90;
                    i+=2;
                } else {
                    sum+=10;
                    i++;
                }
            }
            else if (chars[i]=='V') {
                sum+=5;
                i++;
            }
            else if (chars[i]=='I') {
                if (i<chars.length-1 && chars[i+1]=='V') {
                    sum+=4;
                    i+=2;
                } else if (i<chars.length-1 && chars[i+1]=='X') {
                    sum+=9;
                    i+=2;
                } else {
                    sum+=1;
                    i++;
                }
            }
        }
        return sum;
    }
}
