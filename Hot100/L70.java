package Hot100;

import java.util.LinkedList;


/**
 * 最小栈
 * 难点：在常数时间内返回栈的最小值
 * 思路：常数时间内返回栈的最小值，说明最小值在调用该方法时已经确认,引入一个辅助栈，栈顶元素就是最小值，
 * 每次push元素时，从新增元素和栈顶元素选择一个最小值加入
 */
public class L70 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

//class MinStack {
//
//    Stack<Integer> stack;
//    Node<Integer> preHead;
//
//    public MinStack() {
//        stack = new Stack<>();
//        preHead = new Node<>(-1);
//    }
//
//    public void push(int val) {
//        // 往栈顶存入一个元素
//        stack.push(val);
//        // 维护有序链表
//        Node<Integer> head = preHead.next;
//        if (head==null){
//            preHead.next=new Node<>(val);
//            return;
//        }
//        if (val<head.val){
//            // 比头节点小，头插法
//            preHead.next=new Node<>(val,head);
//            return;
//        }
//        Node<Integer> preNode = preHead;
//        while (head!=null && head.val<=val){
//            head = head.next;
//            preNode=preNode.next;
//        }
//        preNode.next=new Node<>(val,head);
//    }
//
//    public void pop() {
//        Integer pop = stack.pop();
//        // 有序链表删除元素
//        Node<Integer> next = preHead.next;
//        if (next==null){
//            return;
//        }
//        Node<Integer> preNext = preHead;
//        while (next!=null && !Objects.equals(next.val, pop)){
//            // 细节:这里用的是Integer包装类，当值是 -128 到 127，引用相同 == 判断为 true，否则为 false
//            next = next.next;
//            preNext = preNext.next;
//        }
//        if (next!=null){
//            preNext.next = next.next;
//        }
//    }
//
//    public int top() {
//       return stack.peek();
//    }
//
//    public int getMin() {
//        return preHead.next.val;
//    }
//
//    static class Node<T> {
//        T val;
//        int index;
//        Node<T> next;
//
//        public Node(T val) {
//            this.val = val;
//        }
//
//        public Node(T val, Node<T> next) {
//            this.val = val;
//            this.next = next;
//        }
//
//        public Node() {
//
//        }
//
//    }
//}