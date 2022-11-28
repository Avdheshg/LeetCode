class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            
            if (curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")) {
                int first = stack.pop();
                int sec = stack.pop();
                // int res = Integer.parseInt();
                stack.push(operate(curr, first, sec));
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }
        return stack.pop();
    }
        
    public int operate(String curr, int first, int sec) {
        switch(curr) {
            case "+":
                return sec + first;
            case "-":
                return sec - first;
            case "*":
                return sec * first;
            case "/":
                return sec / first;
        }
        return 0;
    }
    
}