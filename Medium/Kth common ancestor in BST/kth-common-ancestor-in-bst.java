//{ Driver Code Starts
import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);

            String[] snums = br.readLine().split(" ");
            int k = Integer.parseInt(snums[0]);
            int x = Integer.parseInt(snums[1]);
            int y = Integer.parseInt(snums[2]);

            Solution T = new Solution();
            // Call the function with the needed parameters
            System.out.println(T.kthCommonAncestor(root, k, x, y));

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

        
        //If both x and y are smaller than data at current node, we call 
        //the function recursively for finding LCA in the left subtree. 
        class Solution {
    public void putParents(Node root,Node p,Map<Node,Node> hm){
        if(root==null) return;
        hm.put(root,p);
        putParents(root.left,root,hm);
        putParents(root.right,root,hm);
    }
    public Node lowestCommonAncestor(Node root,int x,int y){
        if(root==null || root.data==x || root.data==y) return root;
        Node l=lowestCommonAncestor(root.left,x,y);
        Node r=lowestCommonAncestor(root.right,x,y);
        if(l==null) return r;
        else if(r==null) return l;
        return root;
    }
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        Map<Node,Node> parents=new HashMap<>();
        Node LCA=lowestCommonAncestor(root,x,y);
        putParents(root,null,parents);
        Node curr=LCA;
        while(k-->1 && parents.containsKey(curr)){
            curr=parents.get(curr);
        }
        return k==0 && curr!=null?curr.data:-1;
    }
}