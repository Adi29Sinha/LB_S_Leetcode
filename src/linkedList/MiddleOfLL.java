package linkedList;

public class MiddleOfLL {
    /**
     * Definition for singly-linked list.
     */


    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
