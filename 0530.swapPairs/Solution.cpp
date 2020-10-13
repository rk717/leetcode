struct ListNode{
    int val; 
    ListNode* next; 
    ListNode(int x): val(x), next(NULL) {}
};

//迭代
class Solution{
public:
    ListNode* swapPairs(ListNode* head){
        ListNode* dummy = new ListNode(0);
        dummy->next = head;  // dummy -> head 
        ListNode* cur = head;  // dummy cur
        ListNode* pre = dummy;  // pre cur 
        while(cur != nullptr && cur->next != nullptr){
            //pre(1) cur(2) cnext(3) cnext-> next(4) 
            ListNode* cnext = cur->next; 
            cur->next = cnext->next; // 2->4 
            cnext->next = cur;  //4 = 2
            pre->next = cnext;  //pre -> 4
            //pre cnext cur cnext->next
            //这时pre就变成了cur， 然后 cur 就是 cnext->next,
            //也就是 目前 cur 的 next
            pre = cur; 
            cur = cur->next; 
        }

        return dummy->next; 
    }
};


//递归
class Solution{
public:
    void helper(ListNode* cur, ListNode* pre){
        if(cur == nullptr || cur->next == nullptr) return; 
        ListNode* cnext = cur->next; 
        
        //交换 I A B C D
        cur->next = cnext->next;  //B <-> C / I A C B D 
        cnext->next = cur; // B <-> A / I B C A D 
        pre->next = cnext; // 
        pre = cur; 
        cur = cur->next; 
        helper(cur, pre);

    }

    ListNode* swapPairs(ListNode* head){
        ListNode* dummy = new ListNode(0);
        dummy->next = head; 
        helper(head, dummy);
        return dummy->next; 
    }
};

//24
//https://youtu.be/L2BH5snZ5Rw