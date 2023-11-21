import java.util.*;
class Node 
{
    int data;
    Node next;
    public Node left;
    public Node right;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
public class Day19
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Solution obj = new Solution();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}

class Solution
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        Node x = head1, y = head2, res=null,head=null;

        while(x!=null && y!=null){

            if(x.data<y.data)

                x = x.next;

            else if(x.data>y.data)

                y = y.next;

            else{

                Node t = new Node(x.data);

                if(head==null)

                    head = t;

                else

                    res.next=t;

                res = t;

                y = y.next;

                x = x.next;

            }

        }

        return head;

    }
    }
