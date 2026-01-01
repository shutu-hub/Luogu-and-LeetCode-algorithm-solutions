package Hot100;

public class L28 {

    public class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead =new ListNode(-1);
        ListNode cur = preHead;
        int jinWei=0;
        while (l1!=null && l2!=null){
            int sum = l1.val + l2.val+jinWei;
            jinWei=0;
            if (sum>=10) {
                sum = sum - 10;
                jinWei++;
            }
            ListNode node=new ListNode(sum);
            cur.next=node;
            cur=node;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int sum = l1.val + jinWei;
            jinWei=0;
            if (sum>=10) {
                sum = sum - 10;
                jinWei++;
            }
            ListNode node=new ListNode(sum);
            cur.next=node;
            cur=node;
            l1=l1.next;
        }
        while (l2!=null){
            int sum = l2.val + jinWei;
            jinWei=0;
            if (sum>=10) {
                sum = sum - 10;
                jinWei++;
            }
            ListNode node=new ListNode(sum);
            cur.next=node;
            cur=node;
            l2=l2.next;
        }
        // 注意最后一位，有可能两个链表的最后一位和超过了10，那么两个链表都为null了，但需要进位，新创建一个节点
        if (jinWei!=0){
            cur.next=new ListNode(jinWei);
        }
        return preHead.next;
    }
}

