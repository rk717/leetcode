//given the head of linked list and a value x,      
//partition it such that 
//all nodes less than x conme before nodes greater than or equal to x 

#include <iostream>

struct ListNode {
    int val; 
    ListNode* next; 
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

/*
head = [1, 4, 3, 2, 5, 2], x = 3 
[1, 2, 2, 4, 3, 5]
*/

class Solution {
public: 
    ListNode* partition(ListNode* head, int x) {
        if (head == nullptr || head -> next == nullptr) {
            return head; 
        }
        //两个虚拟头，遍历原来的链表一遍进行归类，小于x的归于虚拟头1之后，
        //其余的归于虚拟头2之后，再把虚拟头2后面的链表接到虚拟头1链表后面即可。
        ListNode fakehead1 = ListNode(); 
        ListNode fakehead2 = ListNode(); 
        ListNode* ip1 = &fakehead1;
        ListNode* ip2 = &fakehead2;

        for(ListNode* it = head; it != nullptr; it = it -> next) {
            if (it->val < x) {
                ip1->next = it;
                ip1 = it;
            } else {
                ip2 -> next = it; 
                ip2 = it;
            }
        }
        ip1 -> next = fakehead2.next;
        ip2-> next = nullptr;
        return fakehead1.next;
    }
    /*
        head = [1, 4, 3, 2, 5, 2], x = 3 
                [1, 2, 2, 4, 3, 5]
    */
    /*
        1 < 3               4 > 3               2 < 3                   5 > 3                   2 < 3
        i1 -> next = 1      i2 -> next = 4      i1 (1) -> next = 2      i2 (4) -> next = 5      i1 (2) -> next = 2
        i1 = 1              i2 = 4              i1 = 2                  i2 = 5                  i1 = 2
                                                1 -> 2                  4 -> 5                  1 -> 2 -> 2 

        i1 (2) -> next = f2.next 
    */
};

