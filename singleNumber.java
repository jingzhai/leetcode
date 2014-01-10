
public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int sum = 0;
        for(int i=0;i<A.length;i++) {
            if (map.get(A[i])==null) {
                map.put(A[i],true);
                sum+=A[i];
            }
            else{
                map.remove(A[i]);
                sum-=A[i];
            } 
        }
        return sum;
        
    }
}
