package solution106;

import com.sun.xml.internal.ws.api.pipe.Tube;

class Solution {
    // public boolean calstr(int a[],int b[],string s){
    //     // a和b分别为左右两边的选取情况，s为字符串
    //     string A="";
    //     string B="";
    //     for(int i=0;i<a.length;i++){
    //         A+=a[i];
    //         B+=b[a.length-i];
    //         // 获得a和b
    //     }
    //     if(A==B){
    //         return true;
    //     }
    //     return false;
    // }
    public long solution(int n, String s) {
        for(;n>0;n--){
            result=n*result;
        }
        return result*2;

        int N=2*n;
        int result=0,k=0,p=0;
        int a[]=new int [4];
        int b[]=new int [4];
        for(int i=0;i<(1<<N);i++){
            int num=0;
            k=p=0;
            for(int j=0;j<N;j++){
                if((i&(1<<j))!=0){
                    num++;
                    a[k++]=j;
                }
                b[p++]=j;
            }
            if(num==n){
                // if(calstr(a,b,s)){
                //     result++;
                // }
            }
        }
        return result;



    }
}