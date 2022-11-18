//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class MaxSum
{
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution ob = new Solution();
			    int ans = ob.getMaxSum(root);
			    System.out.println(ans);
                t--;
	        }
    }
}




// } Driver Code Ends


//User function Template for Java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

class Pair{
    int include;
    int exclude;
    Pair(int in,int ex){
        include = in;
        exclude = ex;
    }
}
class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    
    static Pair solve(Node root){
        if(root==null)return new Pair(0,0);
        //we have two options i.e. include or exclulde 
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        //if we include root then sum of the exclude part of the left and right subtree with root data
        int includeRoot = root.data+left.exclude+right.exclude;
        //if we exclude root then we can take the include part or exlude part of left and right subtree
        //for maximum sum, we take the the max
        int excludeRoot = Math.max(left.include,left.exclude)+Math.max(right.include,right.exclude);
        return new Pair(includeRoot,excludeRoot);
    }
    static int getMaxSum(Node root)
    {
        // add your code here
        Pair p = solve(root);
        //we have to return maximum value. so,we have to decide which value have to be taken include or exclude part
        return Math.max(p.include,p.exclude);
    }
}