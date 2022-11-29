class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> al = new ArrayList<>();

        // if the given interval is empty or null
        if (intervals.length == 0 || intervals == null) {
            return al.toArray(new int[0][]);
        }

        // sorting the intervals
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // Save the 1st interval to vars
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int currInterval[]: intervals) {

            // check if the current interval is overlapping or not
                // if overlapping then take the max (increase the size of the interval)
            if (currInterval[0] <= end) {
                end = Math.max(currInterval[1], end);
            } 
            
            // if not overlapping => means V have found an interval which is beyond the range of our stored interval so add our interval to the list and initialise the current interval values to our var so that V can compare them with with other intervals which are left
            else {
                al.add(new int[]{start, end});
                start = currInterval[0];
                end = currInterval[1];
            }

        }
        // at the end, last interval will be left from the loop, so add it to the last
        al.add(new int[]{start, end});

         // Convert the list to array
        return al.toArray(new int[0][]);
    }
}