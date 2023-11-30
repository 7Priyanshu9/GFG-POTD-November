public class Day16 {
    public static String findMinimumLengthString(int N, int K) {
        // Check if N is greater than or equal to 1 and K is greater than or equal to 2
        if (N < 1 || K < 2) {
            return "Invalid input. N should be at least 1 and K should be at least 2.";
        }

        // Initialize the result string
        StringBuilder result = new StringBuilder();

        // Construct the string using a sliding window approach
        for (int i = 0; i < K - 1; i++) {
            result.append(i);
        }

        for (int i = 0; i < N - (K - 1); i++) {
            result.append(i % (K - 1));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        int N = 3;
        int K = 4;

        String minimumLengthString = findMinimumLengthString(N, K);
        System.out.println("Minimum Length String: " + minimumLengthString);
    }
}

