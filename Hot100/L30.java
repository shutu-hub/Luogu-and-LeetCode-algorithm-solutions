package Hot100;

public class L30 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        ListNode listNode = swapPairs(head);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode=listNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        // 不修改引用，只修改head中的val值
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next=head;
        ListNode temp=preHead; // 一个变动的头节点，在迭代过程中temp指向的引用发生变化，但preHead的引用未发生变化
        while (temp.next!=null && temp.next.next!=null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next=node2;
            node1.next=node2.next; // t 1 2 3 4 // t 2 1 3 4 //
            node2.next=node1;
            temp=node1;
        }
        return preHead.next;
    }

    public ListNode method2(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next=method2(newHead.next);
        newHead.next=head;
        return newHead;
    }
}
