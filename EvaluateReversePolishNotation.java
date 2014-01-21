public class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int i=0;
        int result=0;
        while (i<tokens.length) {
            try {
                stack.push(Integer.parseInt(tokens[i]));
            } catch (Exception e) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                if (tokens[i].equals("+")) result=n1+n2;
                else if (tokens[i].equals("-")) result=n1-n2;
                else if (tokens[i].equals("*")) result=n1*n2;
                else if (tokens[i].equals("/")) result=n1/n2;
                stack.push(result);
            } finally {
                i++;
            }
        }
        return stack.peek();
    }
}
