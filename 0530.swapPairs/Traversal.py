#A simple Python program for traversal of a linked list

#Node class
class Node:
    #Function to initialise the node object
    def __init__(self, data):
        self.data = data #Assign data
        self.next = None #Initialize next as null

#Linked list class contains a Node object
class LinkedList:
    #function to initialize head
    def __init__(self):
        self.head = None
    
    #this function prints contents of linked list
    #starting from head
    def printList(self):
        temp = self.head
        while(temp):
            print(temp.data)
            temp = temp.next 

#Code execution starts here
if __name__=='__main__':
    #start with the empty list
    llist = LinkedList()

    llist.head = Node(1)
    second = Node(2)
    third = Node(3)

    llist.head.next = second #link first node with second
    second.next = third #link second node with the third node 

    llist.printList()