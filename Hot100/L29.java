package Hot100;

public class L29 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢节点，让快节点先走n步，慢节点开始走，快节点到达末尾时，两个节点相差n步，慢节点到达要删除的节点的前一个节点
        // 要删除的元素可能是头元素，定义哨兵节点，方便删除头元素
        ListNode preHead = new ListNode(-1);
        preHead.next=head;
        ListNode fast = preHead;
        ListNode slow = preHead;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        // fast没有走到最后一个节点时，快慢指针同时向右走
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return preHead.next;
    }
}
