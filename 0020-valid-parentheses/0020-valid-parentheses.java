class Solution {
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            
            if (curr == '(' || curr == '[' || curr == '{') {
                st.push(curr);
            } else {
                if (!st.isEmpty() && isValid(curr, st.peek())) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    
    public boolean isValid(char curr, char peek) {
        switch(curr) {
            case ')':
                return peek == '(';
            case ']':
                return peek == '[';
            case '}':
                return peek == '{';
        }
        return false;
    }
}