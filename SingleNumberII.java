public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int a = 0; int b = 0; int c = 0;
        for(int i=0;i<A.length; i++){
            b = b|(a&A[i]);  //出现两次的 就加到B里面
            a = a^A[i];    //从A里面删除 出现两次的
            c = ~(a&b);   //如果是三次的 就会同时出现在A和B里面， 
            a = a&c;       //然后删除A里三次的
            b = b&c;       //删除B里三次的
        }
        return a;
    }
}

public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] bits = new int[32];
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<32;j++) {
                bits[j]+=(A[i]&(1<<j))==0?0:1;
            }
        }
        int result=0;
        for (int i=0;i<32;i++) {
            if (bits[i]%3!=0) result+=1<<i;
        }
        return result;
    }
}

public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<A.length;i++) {
            if (map.get(A[i])==null) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i])+1);
            }
        }
        for (int i=0;i<A.length;i++) {
            if (map.get(A[i])==1) return A[i];
        }
        return 0;
    }
}
