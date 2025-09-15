package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L33 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        ListNode preHead = new ListNode(0);
        ListNode newNode = preHead;
        Collections.sort(list);
        for (Integer val : list) {
            ListNode listNode = new ListNode(val);
            newNode.next = listNode;
            newNode=listNode;
        }
        return preHead.next;
    }
}
