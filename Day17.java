
    class TreeNode {
        int data;
        TreeNode left, right;
    
        public TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    
    public class Day17 {
    
        private TreeNode prev, head;
    
      
        private void convertToCDLL(TreeNode root) {
            if (root == null) {
                return;
            }
    
            convertToCDLL(root.left);
    
        
            if (prev == null) {                
                head = root;
            } else {
                
                prev.right = root;
               
                root.left = prev;
            }
    
            
            prev = root;
    
            
            convertToCDLL(root.right);
        }
    
        // Display the circular doubly linked list
        private void displayCDLL() {
            if (head == null) {
                System.out.println("CDLL is empty.");
                return;
            }
    
            TreeNode current = head;
            do {
                System.out.print(current.data + " ");
                current = current.right;
            } while (current != head);
            System.out.println();
        }
    
        public static void main(String[] args) {
            Day17 converter = new Day17();
    
            // Example usage:
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(12);
            root.right = new TreeNode(15);
            root.left.left = new TreeNode(25);
            root.left.right = new TreeNode(30);
            root.right.left = new TreeNode(36);
    
            // Convert binary tree to CDLL
            converter.convertToCDLL(root);
    
            // Display the CDLL
            System.out.println("Circular Doubly Linked List (CDLL):");
            converter.displayCDLL();
        }
    }
    
