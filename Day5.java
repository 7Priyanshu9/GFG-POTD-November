import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day5 {
    public int[] topK(int[] nums, int k) {
       Map<Integer,Integer> M = new HashMap<>();
        for(int i : nums ){
            M.put(i,M.getOrDefault(i,0)+1);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a,b)->(M.get(a) == M.get(b)) ? 
        b-a:M.get(b)-M.get(a));
        
        for(int key : M.keySet()){
            queue.add(key);
        }
        
        nums = new int[k];
        for(int i = 0; i<k;i++){
            nums[i] = queue.remove();
          
        }
          return nums;
}
}

