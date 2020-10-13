# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head 
        
        p = head 
        new_start = p.next 

       
        '''
        1 2 3 4 
        p:1 
        q:2 
        '''
        #p q r s t 
        while(True):
            q = p.next  #new start 
            temp = q.next   # 保存3， 因为 1 2 一交换，2 后面的 3 就丢失了

            q.next = p # 2 放到了1 前面
            
            #判断，是否继续置换，如果temp 存在 或者 temp 下一个 存在就可以
            if not temp or not temp.next: 
                p.next = temp 
                break 
            #如果后面还有数，则后面两个数继续置换
            #2143     1就是 p.next ； 4 就是 temp.next (3的下一个)
            p.next = temp.next 
            p = temp #然后把 p 就是 temp 就是 从 3 开始

            #这个while 就会一直循环，直到 break
        return new_start
