import java.util.*;
class Day26{
   
    void fun(List<Integer> ans,int n,int s){
           if(n <= 0) {ans.add(n);
           return;
           }
           ans.add(n);
           fun(ans,n-5,s);
           ans.add(n);
       }
       public List<Integer> pattern(int N){
           
           List<Integer> res=new ArrayList<>();
           res.add(N);
           if(N<=0) return res;
           fun(res,N-5,0);
           res.add(N);
           return res;
       }
       }
   
   