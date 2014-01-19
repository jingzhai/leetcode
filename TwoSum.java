public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] index = new int[2];
        for (int i=0;i<numbers.length;i++) {
            map.put(numbers[i],i);
        }
        for (int i=0;i<numbers.length;i++) {
            if (map.containsKey(target-numbers[i])) {
                index[0]=i+1;
                index[1]=map.get(target-numbers[i])+1;
                break;
            }
        }
        return index;
    }
}
