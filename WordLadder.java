public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (oneDiff(start,end)) return 2;
        ArrayDeque<ArrayDeque<String>> graph = new ArrayDeque<ArrayDeque<String>>();
        ArrayDeque<String> newlist = new ArrayDeque<String>();
        HashSet<String> used = new HashSet<String>();
        newlist.add(start);
        graph.add(newlist);
        while(used.size()<dict.size()) {
            ArrayDeque<String> prevlist=graph.getLast();
            ArrayDeque<String> curlist = new ArrayDeque<String>();
            for (String s : prevlist) {
                char[] chars = s.toCharArray();
                for (int i=0;i<s.length();i++) {
                    char orig=chars[i];
                    for (int j=0;j<26;j++) {
                        chars[i]=(char)('a'+j);
                        if (chars[i]==orig) continue;
                        String temp=String.valueOf(chars);
                        if (!used.contains(temp) && dict.contains(temp)) {
                            curlist.add(temp);
                            used.add(temp);
                            if (oneDiff(temp,end)) return graph.size()+2;
                        }
                    }
                    chars[i]=orig;
                }
            }
            if (curlist.size()==0) return 0;
            graph.add(curlist);
        }
        return 0;
    }
    private boolean oneDiff(String s1, String s2) {
        boolean onediff=false;
        for (int i=0;i<s1.length();i++) {
            if (s1.charAt(i)!=s2.charAt(i)) {
                if (!onediff) onediff=true;
                else return false;
            }
        }
        return onediff;
    }
}
