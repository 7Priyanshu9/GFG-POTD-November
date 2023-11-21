public class Day21{


    public class Node {
        private int data;
        private Node left;
        private Node right;
    
        // Constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            
        }

        
    public static boolean isIdentical(Node Root1, Node Root2){
    //    check weather root1 and root2 is null or not at the same time 
        if(Root1 == null && Root2 == null){
            return true;
        } else if(Root1 == null || Root2 == null ){
            return false;
        }
//  First we will check weather both have same data or not if yes then true else return false
        else if (Root1.data != Root2.data){
            return false;
        }
        else{
            // recursively traverse accross both the trees to check these same info and at the end returning it 
            return (isIdentical(Root1.left, Root2.left) && isIdentical(Root1.right, Root2.right ));
        }
    }

}
}