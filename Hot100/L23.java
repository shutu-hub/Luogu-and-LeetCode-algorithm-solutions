package Hot100;

public class L23 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        // 创建一个新的链表，头插法
      ListNode newNodeHead = null;
      while (head!=null){
        ListNode node = new ListNode(head.val);
        node.next=newNodeHead;
        newNodeHead=node;
        head=head.next;
      }
      return newNodeHead;
    }
}
