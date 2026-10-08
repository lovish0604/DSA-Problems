import java.util.*;
public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int steps=count-n;
        if(steps==0) return head.next;
        temp=head;
        for(int i=1;i<steps;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}