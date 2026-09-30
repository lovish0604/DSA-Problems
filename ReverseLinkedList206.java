public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null,temp;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
