class Solution {
    
    public int[] searchRange(int arr[], int target) {
        int first = find(arr, target);
        int last = find(arr, target+1) - 1;
            
        if (first <= last) {
            return new int[]{first, last};
        }
        return new int[]{-1, -1};
    }
    
    public int find(int arr[], int target) {
        int n = arr.length, low = 0, high = n-1;
        int ans = n;
        
        while (low <= high) {
            int mid = low + (high-low) / 2;
            
            if (arr[mid] >= target) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    
}