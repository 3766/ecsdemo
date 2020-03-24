package solution106;

class Solution {
    public int result =0;
    public void dfs(int a[],int i,int a1,int b1,String s){
        if(a1>s.length()/2||a1>s.length()/2||i>=s.length()){
            return;
        }
/*        a[i]=0;
        if(a1==s.length()/2){
            if(judge(a,s)){
                result++;
            }
        }*/
        dfs(a,i+1,a1+1,b1,s);
        a[i]=1;
        if(b1==s.length()/2){
            if(judge(a,s)){
                result++;
            }
        }
        dfs(a,i+1,a1,b1+1,s);
    }
    public static String reverse1(String str)
    {
    return new StringBuffer(str).reverse().toString();
    }
    public boolean judge(int a[],String s){
        String A="";
        String B="";
        for(int i=0;i<s.length();i++){
            if(a[i]==1){
                A+=s.charAt(i);
            }
            else{
                B+=s.charAt(i);
            }
        }
        // for(int i=a.length-1;i>=0;i--){
        //     if(a[i]==0){
        //         B+=s.charAt(i);
        //     }
        // }
        B=reverse1(B);
        if(A.equals(B)){
            return true;
        }
        return true;
    }
    public long solution(int n, String s) {
        int a[]=new int [2*n];
        for(int i=0;i<a.length;i++){
            a[i]=0;
        }
        dfs(a,0,0,0,s);
        return result;
    }



}