//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int firstElement(int n) {
        int mod = (int)1e9+7;
        int i=0, j=1;
        int sum = 0;
        if(n==1) return 1;
        for(int x=1;x<n;x++){
            sum = (i+j)%mod;
            i=j;
            j=sum;
        }
        return sum;
    }
}

