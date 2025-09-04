package Hot100;

public class L25 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(hasCycle(head));
    }

    static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

    public  static boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode quick = head;
        ListNode slow = head;
        // 快慢指针，快指针每次走两步，慢指针每次走一步，若快指针不为null但与慢指针相等，则说明有环
        while (quick!=null){
            slow=slow.next;
            quick=quick.next;
            if (quick!=null){
                quick=quick.next;
            }
            if (quick!=null && quick==slow){
                return true;
            }
        }
        return false;
    }
}
