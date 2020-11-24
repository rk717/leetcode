class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        dummy = ListNode(0)
        cur = head 
        while cur:
            pre = dummy 
            while pre.next and pre.next.val <= cur.val:
                pre = pre.next 
            tmp = cur.next 
            cur.next = pre.next 
            pre.next = cur 
            cur = tmp 
        return dummy.next 