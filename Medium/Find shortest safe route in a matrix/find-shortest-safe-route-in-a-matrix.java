//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findShortestPath(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    if(i-1>=0)mat[i-1][j]=-1;
                    if(i+1<n)mat[i+1][j]=-1;
                    if(j-1>=0)mat[i][j-1]=-1;
                    if(j+1<m)mat[i][j+1]=-1;
                    
                }
            }
        }
        int d[][]=new int[n][m];
        for(int t[]:d){
            Arrays.fill(t,Integer.MAX_VALUE);
        }
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(mat[i][0]==1)q.add(new pair(1,i,0));
        }
        int delr[]={-1,0,1};
            int delc[]={0,1,0};
        while(!q.isEmpty()){
            pair p=q.poll();
            int s=p.st;
            int r=p.ro;
            int c=p.co;
            if(c==m-1)return s;
            for(int i=0;i<3;i++){
                int nr=r+delr[i];
                int nc=c+delc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]==1 && d[nr][nc]>s+1){
                    q.add(new pair(s+1,nr,nc));
                    d[nr][nc]=s+1;
                }
            }
            
    }
    return -1;
}
}
class pair{
    int st,ro,co;
    pair(int st,int ro,int co){
        this.st=st;
        this.ro=ro;
        this.co=co;
    }
}