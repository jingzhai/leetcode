public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max=0;
        int curLen=0;
        int start=0;
        for (int i=0;i<s.length();i++) {
            if (!map.containsKey(s.charAt(i))) {
                curLen++;
            } else {
                max=Math.max(curLen,max);
                int lastLoc=map.get(s.charAt(i));
                curLen=i-lastLoc;
                for (int j=start;j<lastLoc;j++) {
                    map.remove(s.charAt(j));
                }
                start=lastLoc+1;
            }
            map.put(s.charAt(i),i);
        }
        max=Math.max(curLen,max);
        return max;
    }
}
