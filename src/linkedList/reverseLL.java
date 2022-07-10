package linkedList;

public class reverseLL {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next1 = null;
        while(curr!=null){
            next1 = curr.next;
            curr.next = prev;
            prev=curr;
            curr = next1;
        }
        head = prev;
        return head;
    }
}
