#include <bits/stdc++.h>
using namespace std;
// https://www.geeksforgeeks.org/delete-nth-node-from-the-end-of-the-given-linked-list/

/*
Given a linked list and an integer N,
the task is to delete the Nth node from the end of the given linked list.
*/

/*
take two pointers, 
first:  point to the head of the linked list 
second: point to the Nth node from the beginning

now keep increment both pointers by one at the same time 
until second is pointing to the last node of the linked list 

after the operations from the previous step, 
first pointer should be pointing to the Nth node from the end by now. 
So, delete the node first pointer is pointing to 


*/

class LinkedList
{
public:
    class Node
    {
    public:
        int data;
        Node *next;
        Node(int d)
        {
            data = d;
            next = NULL;
        }
    };

    Node *head;

    Node *deleteNode(int key)
    {
        Node *first = head;
        Node *second = head;

        for (int i = 0; i < key; i++)
        {
            //if count of nodes in the given linked list is <= N
            if (second->next == NULL)
            {
                //if count = N
                //delete the head node
                if (i == key - 1)
                {
                    head = head->next;
                }
                return head;
            }
            second = second->next;
        }

        //increment both the pointers by one until
        //second pointer reaches the end
        while (second->next != NULL)
        {
            first = first->next;
            second = second->next;
        }

        //first must be pointing to the Nth node from the end by now
        // so delete the node first is pointing to
        first->next = first->next->next;
        return head;
    }
};