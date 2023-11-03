
// You are given an array a, of n elements. Find the minimum index based distance between two distinct elements of the array, x and y. Return -1, if either x or y does not exist in the array.

public class Day2 {
    int minDist(int a[], int n, int x, int y) {
        // code here
           int ans= Integer.MAX_VALUE;
        int idx1=-1;
        int idx2=-1;
        for(int i=0;i<n;i++){
            if(a[i]==x){
               idx1=i; 
            }
            if(a[i]==y){
                idx2=i;
            }
            if(idx1 !=-1 && idx2 !=-1){
                ans=Math.min(ans,Math.abs(idx2-idx1));
            }
        }
        if(idx1==-1 || idx2==-1){
            return -1;
        }
        return ans;
    }
}
