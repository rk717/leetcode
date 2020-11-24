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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        //查找当前链表 的 中点
        ListNode fastNode = head; 
        ListNode slowHead = head; 
        while(fastNode.next != null && fastNode.next.next != null){
            slowHead = slowHead.next; 
            fastNode = fastNode.next.next; 
        }

        ListNode midNode = slowHead.next; 
        slowHead.next = null; //将两个链表 断开
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(midNode);
        return merge(leftHead, rightHead);
    }
        //为两个链表进行 “归并排序”
        /*
            @param leftHead 左链表头
            @param rightHead 右链表头
            @return 当前两个链表的 排序后的头
        */

    private ListNode merge(ListNode leftHead, ListNode rightHead){
        if(leftHead == null){
            return rightHead; 
        }
        if(rightHead == null){
            return leftHead; 
        }
        if(leftHead.val < rightHead.val){
            leftHead.next = merge(leftHead.next, rightHead); 
            return leftHead; 
        }else{
            rightHead.next = merge(leftHead, rightHead.next);
            return rightHead; 
        }
    }
    
}