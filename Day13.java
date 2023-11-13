public class Day13{
    public static int shortestCommonSupersequence(String X,String Y)
    {
            int m = X.length();
            int n = Y.length();
        //Your code here
         int[][] dp = new int[m + 1][n + 1];

        // Fill the table using dynamic programming
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the shortest common supersequence is given by:
        // m + n - length of LCS (Longest Common Subsequence)
        int lcsLength = dp[m][n];
        int shortestSupersequenceLength = m + n - lcsLength;

        return shortestSupersequenceLength;
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int result = shortestCommonSupersequence(X, Y);

        System.out.println("Length of the shortest common supersequence: " + result);
    }
}