import java.util.Arrays;
public class Day4 {
    
    public static int transitionPoint(int arr[], int n) {
        // code here
        int ans = -1;
        Arrays.sort(arr);
        for(int i = 0; i<n;i++){
            if(arr[i] == 1){
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int question[] = {0,0,0,1,1};
        int size = question.length;
        System.out.println(transitionPoint(question, size));
    }
}
