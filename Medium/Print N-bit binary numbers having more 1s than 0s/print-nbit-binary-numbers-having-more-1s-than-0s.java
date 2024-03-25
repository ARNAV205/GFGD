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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> list=new ArrayList<>();
        
       printString(N,list,0,"");
       return list;
     
    }
    public static void printString(int n,ArrayList<String> list,int i,String str){
        if(i==n){
            if(str.charAt(0)!='0'){
                int cntz=0;
                int cnton=0;
                int indz=-1;
                int indone=-1;
                boolean check=false;
                for(int j=0;j<str.length();j++){
                    char ch=str.charAt(j);
                    if(ch=='1'){
                        cnton++;
                        indone=j;
                    }
                    else{
                        cntz++;
                        indz=j;
                    }
                    if(cnton<cntz){
                        check=true;
                        break;
                    }
                }
                
                if(!check){
                     if(cnton>cntz){
                    list.add(str);
                }
                else if(cnton==cntz){
                    if(indone<indz){
                        list.add(str);
                    }
                }
                }
            }
            
           return;
        }
        
            printString(n,list,i+1,str+'1');
            printString(n,list,i+1,str+'0');
         
    }
}

 