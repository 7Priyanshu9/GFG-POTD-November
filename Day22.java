public class Day22{

    // Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.


    public class Node{
        int data ;
        Node left;
        Node right ;


        public Node(int data ){
            this.data = data ;
            this.left= null;
            this.right = null;
        }
    }
    
    private static boolean Sym(Node l, Node r){
        if(r==null && l ==null){
            return true;
        } else if (r== null || l == null ){
            return false;
        } else if (l.data != r.data){
            return false;
        } else{
            return Sym(l.left,r.right) && Sym(l.right,r.left);
        }
    }
    public static boolean isSymmetric(Node root){
        if (root == null ){
            return true ;
        } else{
            return Sym(root.left,root.right);
        }
    }

}