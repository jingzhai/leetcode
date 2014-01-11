public class Solution {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayDeque<Character> queue = new ArrayDeque<Character>();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if ((c=='(') || (c=='[') || (c=='{')) {
                queue.push(c);
            } else if ((c==')') || (c==']') || (c=='}')) {
                if (queue.peek()==null) return false;
                char matching = queue.pop();
                if ( ((c==')')&&(matching!='('))  ||
                     ((c==']')&&(matching!='[')) ||
                      ((c=='}')&&(matching!='{')) )
                      return false;
            } else {
                return false;
            }
        }
        if (queue.peek()!=null) return false;
        return true;
    }
}
