package Hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class L35 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    /**
     * 哈希表 + 双向链表
     * 使用双向链表可以保证，在 O(1) 的时间里 get 和 put 元素
     */
    static class LRUCache {

        class DLinkedNode{
            // 定义节点类
            private int key;
            private int value;
            private DLinkedNode prev;
            private DLinkedNode next;
            public DLinkedNode() {}

            public DLinkedNode(int key, int value) {
                this.key=key;
                this.value=value;
            }
        }

        private Map<Integer,DLinkedNode> cache = new HashMap<>();
        private int capacity;
        private int size;
        private DLinkedNode head;
        private DLinkedNode tail;

        public LRUCache(int capacity) {
            this.capacity=capacity;
            this.size=0;
            cache = new ConcurrentHashMap<>(capacity);
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev =head;
        }

        public int get(int key) {
            DLinkedNode dLinkedNode = cache.get(key);
            if (dLinkedNode==null){
                return -1;
            }
            // 将当前元素移到链表的头部
            moveToHead(dLinkedNode);
            return dLinkedNode.value;
        }


        public void put(int key, int value) {
            DLinkedNode dLinkedNode = cache.get(key);
            if (dLinkedNode!=null){
               dLinkedNode.value = value;
               moveToHead(dLinkedNode);
           }else{
                if (size<capacity){
                    DLinkedNode node = new DLinkedNode(key,value);
                    cache.put(key,node);
                    size++;
                    addToHead(node);
                }else{
                    // 需要先弹出链表末尾元素(最近最少使用)
                    DLinkedNode removedNode = removeTailNode();
                    cache.remove(removedNode.key);
                    size--;
                    DLinkedNode node = new DLinkedNode(key,value);
                    cache.put(key,node);
                    size++;
                    addToHead(node);
                }
            }
        }


        private void addToHead(DLinkedNode node) {
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            node.prev=head;
        }


        /**
         * 将当前链表移动到头部，表示最近被访问
         */
        private void moveToHead(DLinkedNode dLinkedNode) {
            // 移动该节点到头部时，应该先删除在原位置的那个节点，再把该节点加入到头部，而不是直接把该节点加入到头部，会出现元素重复出现的问题
            removeNode(dLinkedNode);
            addToHead(dLinkedNode);
        }


        private DLinkedNode removeTailNode() {
            DLinkedNode removedNode = tail.prev;
            removeNode(removedNode);
            return removedNode;
        }

        private void removeNode(DLinkedNode dLinkedNode){
            dLinkedNode.prev.next=dLinkedNode.next;
            dLinkedNode.next.prev=dLinkedNode.prev;
        }



    }
}
