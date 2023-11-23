import java.util.Scanner;

class AVLTree {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] ip = new int[2000];
            Node root = null;
            Solution obj = new Solution();
            for (int i = 0; i < n; i++) {
                ip[i] = sc.nextInt();
                root = obj.insertToAVL(root, ip[i]);
                if (!obj.isBalancedBST(root)) {
                    break;
                }
            }
            obj.printInorder(root);
            System.out.println();
        }
        sc.close();
    }
}

class Solution {
    class Pair {
        int first;
        boolean second;

        Pair(int first, boolean second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper);
    }

    public Pair isBalanced(Node n) {
        if (n == null) {
            return new Pair(0, true);
        }

        Pair l = isBalanced(n.left);
        Pair r = isBalanced(n.right);

        if (Math.abs(l.first - r.first) > 1) return new Pair(0, false);

        return new Pair(1 + Math.max(l.first, r.first), l.second && r.second);
    }

    public boolean isBalancedBST(Node root) {
        if (!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.print("BST violated, inorder traversal: ");
        } else if (!isBalanced(root).second) {
            System.out.print("Unbalanced BST, inorder traversal: ");
        } else {
            return true;
        }
        return false;
    }

    public void printInorder(Node n) {
        if (n == null) return;
        printInorder(n.left);
        System.out.print(n.data + " ");
        printInorder(n.right);
    }

    public Node insertToAVL(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insertToAVL(node.left, data);
        } else if (data > node.data) {
            node.right = insertToAVL(node.right, data);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int bf = getBalance(node);
        if (bf > 1 && data < node.left.data) return rightRotate(node);
        if (bf < -1 && data > node.right.data) return leftRotate(node);
        if (bf > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (bf < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }
}

class Node {
    int data, height;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
        height = 1;
    }
}
