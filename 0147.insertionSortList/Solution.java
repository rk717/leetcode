class Solution{
    public ListNode insertionSortList(ListNode head){
        if(head == null || head.next == null) return head; 

        ListNode dummy = new ListNode(-1);  
        dummy.next = head;                             
        ListNode cur = head; 
        ListNode prev = null; 
        ListNode temp = null;                        

        while(cur != null && cur.next != null){
            if(cur.val <= cur.next.val){  //说明 cur后面的 比 cur 大，所以 继续
                cur = cur.next; 
            }else{
                temp = cur.next; //说明cur 比 cur 后面的 大，所以 把cur 后面的保存到 temp
                cur.next = cur.next.next; //然后继续向后
                
                //从这开始 要 确定 temp 的位置
                prev = dummy; 
                while(prev.next.val <= temp.val){
                    prev = prev.next; 
                }

                temp.next = prev.next; 
                prev.next = temp; 
            }
        }

        return dummy.next; 
    }
}

//https://www.youtube.com/watch?v=N1VVLLan6S0&ab_channel=JacobHuang