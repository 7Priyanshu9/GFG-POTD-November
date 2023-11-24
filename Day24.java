import java.util.*;
import java.io.*;

public class Day24 {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Long> arr = new ArrayList<>();
        Long dp[][] = new Long[n][n];
        Long mod=1000000007L;
        
        for(int line = 0 ; line < n ; line++)
        {
            for(int i = 0 ; i <= line ; i++)
            {
                if(i == 0 || i == line)
                {
                    dp[line][i] = 1%mod;
                    if(line+1 == n)
                    {
                        arr.add(dp[line][i]);
                    }
                }
                else
                {
                    dp[line][i] = ((dp[line-1][i-1])%mod + (dp[line-1][i])%mod)%mod;
                    if(line+1 == n)
                    {
                        arr.add(dp[line][i]);
                    }
                }
            }
        }
        
        return arr;
    }
}
    