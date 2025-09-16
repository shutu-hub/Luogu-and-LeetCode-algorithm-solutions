package Hot100;

public class L34 {

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        return spilt(lists,0, lists.length-1);
    }

    public ListNode spilt(ListNode[] lists,int l,int r) {
        if (l>=r){
            return lists[l];
        }
        int m = (l+r)>>1;
        ListNode leftNode =spilt(lists,l,m);
        ListNode rightNode = spilt(lists, m + 1, r);
        return  mergeTwoListNode(leftNode,rightNode);
    }

    private ListNode mergeTwoListNode(ListNode leftNode, ListNode rightNode) {
        ListNode preHead = new ListNode(0);
        ListNode head = preHead;
        while (leftNode!=null && rightNode!=null){
            if (leftNode.val<=rightNode.val){
                // 左边节点插入
                ListNode listNode = new ListNode(leftNode.val);
                head.next = listNode;
                head = listNode;
                leftNode = leftNode.next;
            }else{
                // 右边节点插入
                ListNode listNode = new ListNode(rightNode.val);
                head.next = listNode;
                head = listNode;
                rightNode = rightNode.next;
            }
        }
        while (leftNode!=null){
            // 左边节点插入
            ListNode listNode = new ListNode(leftNode.val);
            head.next = listNode;
            head = listNode;
            leftNode = leftNode.next;
        }
        while (rightNode!=null){
            // 右边节点插入
            ListNode listNode = new ListNode(rightNode.val);
            head.next = listNode;
            head = listNode;
            rightNode = rightNode.next;
        }
        return preHead.next;
    }
}
