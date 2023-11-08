import java.util.ArrayList;

public class Day8 {
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
            int n = matrix.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            if(i%2 != 0){
                for(int j = n-1; j>=0;j--){
                    ans.add(matrix[i][j]);
                }
            } else{
                for(int j = 0 ;j < n ; j++){
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans ;
    }
}
