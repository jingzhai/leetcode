public class Solution {
    public int longestConsecutive(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (num==null || num.length==0) return 0;
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        
        for (int i=0;i<num.length;i++) {
            map.put(num[i],false);
        }
        int longest=0;
        for (int i=0;i<num.length;i++) {
            int count=0;
            if (map.get(num[i])==false) {
                map.put(num[i],true);
                count++;
                for (int j=num[i]-1;j>=Integer.MIN_VALUE;j--) {
                    if (map.get(j)!=null) {
                        map.put(j,true);
                        count++;
                    } else {
                        break;
                    }
                }
                for (int j=num[i]+1;j<=Integer.MAX_VALUE;j++) {
                    if (map.get(j)!=null) {
                        map.put(j,true);
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count>longest) {
                longest=count;
            }
        }
        return longest;
    }
}
