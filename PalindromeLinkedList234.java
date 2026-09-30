public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null,temp;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        if(fast!=null) slow=slow.next;
        while(slow!=null){
            if(prev.val!=slow.val) return false;
            prev=prev.next;
            slow=slow.next;
        }
        return true;
    }
}