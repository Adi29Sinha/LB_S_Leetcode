package linkedList;

public class Merge2SortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        // start with the linked list
        // whose head data is the least
        if (list1.val < list2.val)
            return mergeUtil(list1, list2);
        else
            return mergeUtil(list2, list1);
    }

    ListNode mergeUtil(ListNode list1, ListNode list2)
    {
        // if only one listnode in first list
        // simply point its head to second list
        if (list1.next == null) {
            list1.next = list2;
            return list1;
        }

        // Initialize current and next pointers of
        // both lists
        ListNode curr1 = list1, next1 = list1.next;
        ListNode curr2 = list2, next2 = list2.next;

        while (next1 != null && curr2 != null) {
            // if curr2 lies in between curr1 and next1
            // then do curr1->curr2->next1
            if ((curr2.val) >= (curr1.val) && (curr2.val) <= (next1.val)) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;

                // now let curr1 and curr2 to point
                // to their immediate next pointers
                curr1 = curr2;
                curr2 = next2;
            }
            else {
                // if more nodes in first list
                if (next1.next != null) {
                    next1 = next1.next;
                    curr1 = curr1.next;
                }

                // else point the last listnode of first list
                // to the remaining nodes of second list
                else {
                    next1.next = curr2;
                    return list1;
                }
            }
        }
        return list1;
    }

}
