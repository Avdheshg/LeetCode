// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // code here
        
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (twoPA(arr, arr[i]))
                return true;
        }
        return false;
        
    }
    
    public boolean twoPA(int arr[], int tar) {
        tar = tar*tar;
        int low = 0, high = arr.length-1;
        
        while (low < high) {
            int curr = arr[low]*arr[low] + arr[high]*arr[high];
            
            if (curr == tar) return true;
            else if (curr > tar) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    } 
}