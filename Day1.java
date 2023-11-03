import java.util.HashMap;

// //Given an array arr[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array. Your task is to count the frequency of all numbers from 1 to N. Make in-place changes in arr[], such that arr[i] = frequency(i). Assume 1-based indexing.
// Note: The elements greater than N in the array can be ignored for counting and do modify the array in-place. 

public class Day1 {
     public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
            HashMap<Integer,Integer>hm = new HashMap<>();
        
        for(int x : arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        
        for(int i=0;i<N;i++){
            arr[i] = hm.getOrDefault(i+1,0);
        }
    }
}
