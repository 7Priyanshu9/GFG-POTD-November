import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Day20 {
    // Modify the buildTree method to accept an array of values
    static Node buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("N")) return null;
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            Node currNode = q.remove();
            String currVal = values[i++];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                q.add(currNode.left);
            }
            if (i >= values.length) break;
            currVal = values[i++];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                q.add(currNode.right);
            }
        }
        return root;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine(); // Read the space-separated string
            String[] values = s.split(" "); // Split the string into an array of values
            Node root = buildTree(values); // Pass the array of values to buildTree
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.sumK(root, k));
        }
    }
}

class Solution {
    static final int MOD = 1000000007;

    public int sumK(Node root, int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        int[] count = new int[1];
        dfs(root, k, 0, prefixSumFreq, count);
        return count[0];
    }

    private void dfs(Node node, int k, int currentSum, Map<Integer, Integer> prefixSumFreq, int[] count) {
        if (node == null) return;
        currentSum += node.data;
        count[0] = (count[0] + prefixSumFreq.getOrDefault(currentSum - k, 0)) % MOD;
        if (currentSum == k) count[0]++;
        prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        dfs(node.left, k, currentSum, prefixSumFreq, count);
        dfs(node.right, k, currentSum, prefixSumFreq, count);
        prefixSumFreq.put(currentSum, prefixSumFreq.get(currentSum) - 1);
    }
}
