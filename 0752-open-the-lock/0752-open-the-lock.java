class Solution {
    public int openLock(String[] deadends, String target) {
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        int depth = -1;
        q.addAll(Arrays.asList("0000"));
        while(!q.isEmpty()) {
            depth++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String node = q.poll();
                if(node.equals(target))
                    return depth;
                if(visited.contains(node))
                    continue;
                visited.add(node);
                q.addAll(getSuccessors(node));
            }
        }
        return -1;
    }
    
    public List<String> getSuccessors(String str) {
        System.out.println("***** " + str + " ***********");
        List<String> res = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            String minus = str.substring(0, i) + (str.charAt(i) == '0' ? 9 :  str.charAt(i) - '0' - 1) + str.substring(i+1);
            String plus = str.substring(0, i) + (str.charAt(i) == '9' ? 0 :  str.charAt(i) - '0' + 1) + str.substring(i+1);
            res.add(plus);
            res.add(minus);
            System.out.println("plus " + plus + "\tminus " + minus);
        }
        return res;
    }
}