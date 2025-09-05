package Hot100;

public class L27 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 定义一个哨兵节点（*），这样可以避免null，也可以快速返回头节点
        ListNode preHead = new ListNode(-1);
        ListNode head=preHead;// head节点也指向哨兵节点，没有额外开辟空间，在第一次比较再给head赋予正确的值
        // 尾插法
        while (list1!=null && list2!=null){
            if (list1.val<list2.val){
                head.next=list1;
                head=head.next;
                list1=list1.next;
            }else{
               head.next=list2;
               head=head.next;
                list2=list2.next;
            }
        }
        while (list1!=null){
            head.next=list1;
            head=head.next;
            list1=list1.next;
        }
        while (list2!=null){
            head.next=list2;
            head=head.next;
            list2=list2.next;
        }
        return preHead.next;
    }
}
