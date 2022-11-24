class Solution {
    public int numSquares(int n) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int steps = 0;
        
        q.offer(0);
        set.add(0);
            
        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int j = 1; j*j <= n; j++) {
                    int pSq = curr + (j*j);
                    
                    if (pSq == n) {
                        return steps;
                    }
                    if (pSq > n) {
                        break;
                    }
                    
                    if (!set.contains(pSq)) {
                        set.add(pSq);
                        q.offer(pSq);
                    }
                }
            }
        }
        return steps;
    }
}