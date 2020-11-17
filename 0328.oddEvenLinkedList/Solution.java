/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head; 
        }

        ListNode oddn = head; 
        ListNode oddh = oddn; 
        ListNode evenn = head.next; 
        ListNode evenh = evenn; 
        ListNode current = evenn.next; 

        boolean flag = true; 
        while(current != null){
            if(flag){
                oddn.next = current; 
                oddn = oddn.next; 
                flag = false; 
            }else{
                evenn.next = current; 
                evenn = evenn.next;  
                flag = true; 
            }
            current = current.next; 
        }

        evenn.next = null; 
        oddn.next = evenh; 
        return oddh; 
    }
}