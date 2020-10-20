

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
import java.util.*;

//keep the linked list in the linear list
/*
class Solution {
    public void reorderList(ListNode head) {
        if(head == null){
            return; 
        }

        //store in list
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next; 
        }

        //head and end pointer, take the element one by one 
        int i = 0, j = list.size() - 1; 
        while(i < j){
            list.get(i).next = list.get(j);
            i++; 

            //if there are even nodes, they will meet previously
            if(i == j){
                break; 
            }

            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null; 


    }
}
*/

//find the middle of the linked list, separate from the middle, then 
//inverse the second one, and connect the first half one by one with 
//the second half. 
class Solution {
    public void reorderList(ListNode head) {
        //0或1个节点
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        //寻找链表的中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表的中点为slow,将中点后的链表翻转
        if (slow.next != null) {
            ListNode pre = null;
            ListNode cur = slow.next;
            ListNode curNext = null;
            slow.next = null; //断链,将链表一分为二         
            //翻转链表
            while(cur != null) {
                curNext = cur.next;
                cur.next = pre;
                pre = cur;
                cur = curNext;
            }
            ListNode p = head;
            cur = pre;
            curNext = null;
            //将翻转后的第二段链表插第一段链表的对应的位置
            while(cur != null) {
                curNext = cur.next;
                cur.next = p.next;
                p.next = cur;
                p = p.next.next;
                cur = curNext;
            }
        }
    }
}

