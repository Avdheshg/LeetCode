class Solution {
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : arr) {
            set.add(x);
        }

        int size = 0;
        
        for (int x : arr) {
            int count = 1;
            if (set.contains(x - 1) == false) {
                while (set.contains(x + count)) {
                    count++;
                }
                size = Math.max(size, count);
            }
        }
        
        return size;
    }
}