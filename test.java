package solution106;

import com.sun.xml.internal.ws.api.pipe.Tube;

class Solution {
    public boolean calstr(int a[],int b[],String s){
        // a和b分别为左右两边的选取情况，s为字符串
        String A="";
        String B="";
        for(int i=0;i<a.length;i++){
            A+=s.charAt(a[i]);
            B=B+s.charAt(b[a.length-i-1]);
            // B+=b[i];
            // 获得a和b
        }
        if(A.equals(B)){
            return true;
        }
        return false;
    }
    public long solution(int n, String s) {
        int N=2*n;
        int result=0,k=0,p=0;
        int a[]=new int [n];
        int b[]=new int [n];
        for(int i=0;i<(1<<N);i++){
            k=p=0;
            for(int j=0;j<N;j++){
                if((i&(1<<j))!=0){
                    if(k==n){
                        break;
                    }
                    a[k++]=j;

                }
                else{
                    if(p==n){
                        break;
                    }
                    b[p++]=j;
                    
                }
            }
            if(k==n&&p==n){
                if(calstr(a,b,s)){
                    result++;
                }
            }
        }
        return result;
    }
}