public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S == null || T == null || S.length() == 0 || T.length() == 0) {
            return "";
        }
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        //initialize needToFind[], record the characters and the # of occurrences in T
        for (int i = 0; i < T.length(); i++) {
            needToFind[T.charAt(i)]++;
        }

        int minWinLen = S.length()+1;
        int hasFoundCount = 0, tLen = T.length();
        int minWinBeg = 0, minWinEnd = 0;
        for (int curBegin = 0, curEnd = 0; curEnd < S.length(); curEnd++) {
            if (needToFind[S.charAt(curEnd)] == 0) {
                continue;
            }
            hasFound[S.charAt(curEnd)]++;
            if(hasFound[S.charAt(curEnd)] <= needToFind[S.charAt(curEnd)]){
                hasFoundCount++;
            }
            
            if(hasFoundCount == tLen){
                while(needToFind[S.charAt(curBegin)] == 0 || hasFound[S.charAt(curBegin)] > needToFind[S.charAt(curBegin)]){
                    if(hasFound[S.charAt(curBegin)] > needToFind[S.charAt(curBegin)]){
                        hasFound[S.charAt(curBegin)]--;
                    }
                    curBegin++;
                }
                
                int curWinLen = curEnd - curBegin + 1;
                if(curWinLen < minWinLen){
                    minWinBeg = curBegin;
                    minWinEnd = curEnd;
                    minWinLen = curWinLen;
                }
            }
        }

        if (hasFoundCount == T.length()) {
            return S.substring(minWinBeg, minWinEnd + 1);
        }

        return "";
    }
}
