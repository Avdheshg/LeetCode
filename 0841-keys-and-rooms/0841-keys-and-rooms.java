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

/* 
        Why hashset?
        we used as  hashset for two reasons
	        1. track the rooms which we are already visited or opened
	        2. at the end, after the traversal of all the rooms, this hashset will be used to decide whether we have opened all the rooms or not

        why stack? 
        we are going to use dfs algorithm which means that after opening the current room whichever keys we will get from this room we will open that room in the next iteration

        Algorithm
            * we will define hashset for visited rooms and add 0 as visited room
            * define a stack so that we can hold the keys which we have got from the current room and add 0  to the stack which means that we have keys for 0th room as given in the question
            * loop until we have keys left the stack
                * pop from the stack it means that we have opened the room by taking the keys from the stack
                * open the room from the popped key and get the keys present in this room
                * Traverse all the keys which we have got after opening the room
                    * check if if for the current key the room is already opened
                        * if not opened then mark the current room as visited
                        * add the current key to the stack so that in future we can open this room

            * at the end if the visited rooms size is equal to the given room size it means that we have opened all the rooms successfully

     */