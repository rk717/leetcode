package swapPairs;

class Solution{
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode current = dummy; 
        while(current.next != null &&
                current.next.next != null){
                    swap2(current);
                    current = current.next.next; 
                }
                return dummy.next; 
    }

    /*
    D a  b  c  e  f 
      du 
    D b  du
    */
    private void swap2(ListNode pre){
        //if(pre.next == null || pre.next.next == null) return; 
        ListNode dummy = pre.next; 
        pre.next = dummy.next;  
        dummy.next = dummy.next.next;  
        pre.next.next = dummy; 
    }

    public static class ListNode{
        int val;
        ListNode next; 
        ListNode(){}
        ListNode(int val) {this.val = val; }
        ListNode(int val, ListNode next){this.val = val; this.next = next; }
    }
}


/*
24.
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
给定 1->2->3->4, 你应该返回 2->1->4->3.
*/