package swapPairs;

//java program to pairwise swap elements of a linked
public class LinkedList {
    Node head; //head of list

    class Node{
        int data; 
        Node next; 
        Node(int d){
            data = d; 
            next = null; 
        }
    }

    void pairWiseSwap(){
        Node temp = head; 

        /*traverse only till there are atleast 2 nodes left*/
        while (temp != null && temp.next != null){
            //swap the data
            int k = temp.data; 
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next; 
        }
    }

    //Inserts a new Node at front of the list
    public void push(int new_data){
        //1&2: allocate the Node & put in the data
        Node new_node = new Node(new_data);

        //make next of new Node as head
        new_node.next = head; 

        //move the head to point to new Node
        head = new_node; 
    }

    //function to print linked list
    void printList(){
        Node temp = head; 
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next; 
        }
        System.out.println();
    }

    //Driver program to test above functions
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        //created Linked List 1->2->3->4->5
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked list before calling pairwiseSwap()");
        llist.printList();

        llist.pairWiseSwap();

        System.out.println("Linked list after calling pairwiseswap()");
        llist.printList();
    }


}
