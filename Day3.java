import java.util.HashSet;


// Given an array arr of n integers, write a function that returns true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.
// TC 0(n^2) SC 0(n)

public class Day3 {
     boolean checkTriplet(int[] arr, int n) {
        // code here
        HashSet<Integer> st = new HashSet<>();
        for(int i = 0 ; i<n;i++){
            st.add(arr[i]*arr[i]);
        }
        for(int i = 0;i<n;i++){
            for( int j = i+1; j<n; j++ ){
                int c = arr[i]*arr[i]+arr[j]*arr[j];
                if(st.contains(c)){
                    return true;
                }
            }
        }
        return false;
    }
}
