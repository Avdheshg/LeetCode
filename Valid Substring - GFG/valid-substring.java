//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S)
    {
        int op = 0;
        int cp = 0;
        int n = S.length();
        
        int ans = 0;
        
        for(int i=0; i<n; i++)
        {
            char ch = S.charAt(i);
            
            if(ch=='(') op++;
            else cp++;
            
            if(cp==op) ans = Math.max(ans, cp+op);
            
            if(cp>op) op = cp = 0;
        }
        
        op = cp = 0;
        
        for(int i=n-1; i>=0; i--)
        {
            char ch = S.charAt(i);
            
            if(ch=='(') op++;
            else cp++;
            
            if(cp==op) ans = Math.max(ans, op + cp);
            
            if(op>cp) op = cp = 0;
        }
        
        return ans;
        
    }
};