#node class
class Node: 
    #Function to initialise the node object
    def __init__(self, data):
        self.data = data # assign data
        self.next = None #initialize next as null

#linked list class contains a node object
class LinkedList:    
    #Function to initialize head
    def __init__(self):
        self.head = None

#code execution starts here 
if __name__=='__main__': #运行的 module 的名字都会是 __main__
    #starts with the empty list 
    llist = LinkedList()

    llist.head = Node(1)
    second = Node(2)
    third = Node(3)

    ''' 
    Three nodes have been created. 
    We have references to these three blocks as head, 
    second and third 
  
    llist.head        second              third 
         |                |                  | 
         |                |                  | 
    +----+------+     +----+------+     +----+------+ 
    | 1  | None |     | 2  | None |     |  3 | None | 
    +----+------+     +----+------+     +----+------+ 
    '''
    llist.head.next = second #Link first node with second
    ''' 
    Now next of first Node refers to second.  So they 
    both are linked. 
  
    llist.head        second              third 
         |                |                  | 
         |                |                  | 
    +----+------+     +----+------+     +----+------+ 
    | 1  |  o-------->| 2  | null |     |  3 | null | 
    +----+------+     +----+------+     +----+------+  
    '''
    second.next = third #Link second node with the third node
    ''' 
    Now next of second Node refers to third.  So all three 
    nodes are linked. 
  
    llist.head        second              third 
         |                |                  | 
         |                |                  | 
    +----+------+     +----+------+     +----+------+ 
    | 1  |  o-------->| 2  |  o-------->|  3 | null | 
    +----+------+     +----+------+     +----+------+  
    '''