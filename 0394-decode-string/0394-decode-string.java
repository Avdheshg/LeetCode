class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
            
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                
                StringBuilder sb = new StringBuilder();
                
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                    
                stack.pop();
                String str = sb.toString();
                
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                
                int count = Integer.valueOf(sb.toString());
                
                while (count > 0) {
                    for (char c : str.toCharArray()) {
                        stack.push(c);
                    }
                    count--;
                }
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}