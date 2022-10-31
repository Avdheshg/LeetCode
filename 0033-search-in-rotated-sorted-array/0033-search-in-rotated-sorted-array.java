class Solution {
    public int search(int[] nums, int tar) {
        
        // M-2 :: O(logn)
        int low = 0, high = nums.length-1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            
            if(tar == nums[mid]) return mid;
            
            if(nums[mid] <= nums[high]) {
                
                if(tar > nums[mid] && tar <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            } else if(nums[mid] >= nums[low]) {
                
                if(tar >= nums[low] && tar < nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        return -1;
        
        // M-1 ::  O(n)
//         for(int i = 0; i < nums.length; i++) {
            
//             if(nums[i] == target)
//                 return i;
//         }
//         return -1;
    }
}