package solution106;

class Solution {
    public static int result =0;
    public static int look(int a[],int k,String str) {
    	int location=0;
    	int mark=0;
    	for(int i=0;i<str.length();i++) {
    		location=str.indexOf(str.charAt(k),location);
    		if(a[i]==1) {
    			mark++;
    		}
    	}
    	String s="";
    	s+=str.charAt(k);
    	return find(str,s,mark);
    }
    public static int find(String str,String s,int num) {
//    	num 第几个数，s 搜寻的字符， str 字符串 ，返回对称的位置
    	int location=0;
    	for(int i=0;i<num;i++) {
    		location=str.indexOf(s,location);
    	}
    	return location;
    }
    
    public static boolean mySum(int a[]){
        int sum=0;
        for (int i=0;i<a.length/2;i++){
            sum+=a[i];
        }
        if(sum!=0){
            return true;
        }
        return false;
    }
    public static void dfs(int a[],int b[],int i,int a1,int b1,String s){
        if(a1>s.length()/2||b1>s.length()/2||i>=s.length()){
            return ;
        }
        if(i>a.length/2){
            if(!mySum(a)){
                return ;
            }
        }
        dfs(a,b,i+1,a1+1,b1,s);
        if(b[i]==1) {
//        	对称性剪枝
        	return;
        }
        a[i]=1;
        
//        int b[]=new int [8];
        int mark=look(a,i,s);
        b[mark]=1;
        if(b1==s.length()/2-1){
            if(judge(a,s)){
                result++;
            }
        }
        dfs(a,b,i+1,a1,b1+1,s);
        a[i]=0;
        b[mark]=0;
    }
    public static String reverse1(String str)
    {
    return new StringBuffer(str).reverse().toString();
    }
    public static boolean judge(int a[],String s){
        String A="";
        String B="";
        for(int i=0;i<s.length();i++){
            if(a[i]==1){
                A+=s.charAt(i);
            }
            if(a[i]==0){
                B+=s.charAt(i);
            }
        }
        // for(int i=a.length-1;i>=0;i--){
        //     if(a[i]==0){
        //         B+=s.charAt(i);
        //     }
        // }
        B=reverse1(B);
//        cabaacba
        if(A.equals(B)){
            return true;
        }
        return false;
    }
    public static long solution(int n, String s) {
        int a[]=new int [2*n];
        int b[]=new int [2*n];
        for(int i=0;i<a.length;i++){
            a[i]=0;
            b[i]=0;
        }
        dfs(a,b,0,0,0,s);
        System.out.println(result);
        return result;
    }
}