package Hot100;
import java.util.HashMap;
import java.util.Map;

public class L32 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
       // 创建一个map，用来作原节点和新节点的映射,这样原节点可以拿到新节点，又
        // 可以指向next和random节点，next和random同样也可以拿到对应的新节点，从而可以完成深拷贝
        Map<Node,Node> map = new HashMap<>();
        Node temp = head;
        while (temp!=null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp = head;
        while (temp!=null){
            // 给所有新节点设置next和random节点
            Node newNode = map.get(temp);
            newNode.next = map.get(temp.next);
            newNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
