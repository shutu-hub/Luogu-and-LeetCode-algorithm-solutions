package Hot100;

public class L31 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



      public ListNode reverseKGroup(ListNode head, int k) {
          ListNode preHead = new ListNode(0);
          preHead.next=head;
          ListNode tempPre = preHead;
          while (head!=null){
            // 判断是否还有k个节点
            ListNode tail = tempPre;
            for (int i = 0; i < k; i++) {
                tail=tail.next;
                if (tail==null){
                  // 没有k个节点了，都已经翻转，直接返回头节点
                  return preHead.next;
                }
            }
            // 对head-tail区间中的k个节点进行翻转
            ListNode next = tail.next;// 记录翻转前为尾节点的下一个节点，方便进行拼接
            ListNode[] listNodes = myReverse(head, tail);
             head = listNodes[0];
             tail = listNodes[1];
            tempPre.next=head;
            tail.next=next;
            // 变更新的head节点
            tempPre=tail;
            head=tail.next;
          }
          return preHead.next;
      }

  /**
   * 实现对head和tail区间的翻转
   * @param head
   * @param tail
   * @return
   */
  public ListNode[] myReverse(ListNode head, ListNode tail) {
      ListNode prev = tail.next;
      ListNode p = head;
      while (prev!=tail){
        ListNode nex = p.next;
        p.next=prev;
        prev=p;
        p=nex;
      }
      return new ListNode[]{tail,head};
  }


}
