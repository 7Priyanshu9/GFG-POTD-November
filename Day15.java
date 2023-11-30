public class Day15 {
    public static String findBetterString(String str1, String str2) {
    int distinctSubsequences1 = countDistinctSubsequences(str1);
    int distinctSubsequences2 = countDistinctSubsequences(str2);

    if (distinctSubsequences1 >= distinctSubsequences2) {
        return str1;
    } else {
        return str2;
    }
}

private static int countDistinctSubsequences(String str) {
    int[] lastOccurrence = new int[256];
    int[] dp = new int[str.length() + 1];
    dp[0] = 1; // Empty string has one subsequence (empty)

    for (int i = 1; i <= str.length(); i++) {
        dp[i] = 2 * dp[i - 1]; // Doubling the count for subsequences ending at the current character

        if (lastOccurrence[str.charAt(i - 1)] != 0) {
            dp[i] -= dp[lastOccurrence[str.charAt(i - 1)] - 1];
        }

        lastOccurrence[str.charAt(i - 1)] = i;
    }

    return dp[str.length()] - 1; 
}
}
