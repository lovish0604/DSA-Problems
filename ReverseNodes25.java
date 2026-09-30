public class ReverseNodes25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int c=0;
        while(temp!=null && c<k){
            temp=temp.next;
            c++;
        }
        if(c==k){
            ListNode rHead=reverse(head,k);
            head.next=reverseKGroup(temp,k);
            return rHead;
        }
        return head;
    }
    public ListNode reverse(ListNode head, int k) {
        ListNode curr=head;
        ListNode next=head;
        ListNode prev=head;
        while(k>0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            k--;
        }
        return prev;
    }
}
