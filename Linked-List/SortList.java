public class SortList {
    public ListNode sortList(ListNode head) {
    
        //Base Case
        
        if(head==null || head.next == null)return head;
        
        
        // break linked list into 2 halvs, after finding mid
        
        ListNode mid = midF(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        
        //recursive calls to sort both halves
        
        left = sortList(left);
        right = sortList(right);
        
         //merge both left and right halves
        ListNode result = merge(left, right);
        
        return result;
    }
        public ListNode midF(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        }
        public ListNode merge(ListNode head1, ListNode head2){
            if(head1 == null)
                return head2;
            if(head2 == null)
                return head1;
            ListNode ans = new ListNode(-1);
            ListNode temp = ans;
            while(head1 != null && head2 != null){
                if(head1.val < head2.val){
                    temp.next = head1;
                    temp = temp.next;
                    head1 = head1.next;
                }
                else{
                    temp.next = head2;
                    temp = temp.next;
                    head2 = head2.next;
                }
            }
            while(head1 != null){
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            while(head2 != null){
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
            return ans.next;    
        }
}
