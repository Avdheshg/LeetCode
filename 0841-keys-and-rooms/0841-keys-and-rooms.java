class Solution {
    
    // https://www.youtube.com/watch?v=oYeGiShGn2k&ab_channel=KevinNaughtonJr.
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visitedRooms = new HashSet<>();
        visitedRooms.add(0);
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int keyForRoom = stack.pop();
            List<Integer> foundKeys = rooms.get(keyForRoom);
            
            for (int key : foundKeys) {
                if (!visitedRooms.contains(key)) {
                    visitedRooms.add(key);
                    stack.push(key);
                }
            }
        }
        
        return visitedRooms.size() == rooms.size();
    }
}