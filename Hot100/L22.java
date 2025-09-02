package Hot100;

import java.util.HashMap;

public class L22 {
    public static void main(String[] args) {

    }
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
   }

    /**
     * 法一
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode x =headA;
        ListNode y =headB;
        HashMap<ListNode,Integer> map = new HashMap<>();
        for (;x!=null;x=x.next){
            map.put(x,1);
        }
        for (;y!=null;y=y.next){
            if (map.containsKey(y)){
                return y;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode x =headA;
        ListNode y =headB;
        // 双指针 假设相交节点到链表末尾的长度为c,headA到相交节点的长度为a,headB到相交节点的长度为b
        // 如果 a == b,则双指针依次向后即可
        // 如果 a != b,则 x 链表先到末尾,则 x = headB,y 链表先到末尾,则 y = headA
        // 这样 a链表走了 a+c+b,b链表走了 b+c+a,总长度相同，同时到达相交节点，若没有相交节点则都为 null
        while (x!=y){
            x = x==null?headB:x.next;
            y = y==null?headA:y.next;
        }
        return x;
    }
}
