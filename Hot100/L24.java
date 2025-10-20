package Hot100;

import java.util.ArrayList;

public class L24 {

    public static class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        isPalindrome( head);
    }
    public static boolean isPalindrome(ListNode head) {
        // 把元素加到数组中，双指针进行比较
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head!=null){
           arrayList.add(head.val);
           head=head.next;
        }
        int end=arrayList.size()-1;
        int start=0;
        while (start<end){
            if (!arrayList.get(start).equals(arrayList.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
