package RuMen;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.LinkedList;

public class Test01 {
    public static void main(String[] args) throws Exception {
        Long[] nums={1L,2L,3L,4L,5L};
        /**
         *        3
         *    1       4
         *      2        5
         */
        BiNode<Long> integerBiNode = new BiNode<>();
        initialTree(nums,0,nums.length-1,integerBiNode);
        travelTree(integerBiNode);
        System.out.println();
        preTravel(integerBiNode);
        System.out.println();
        inTravel(integerBiNode);
        System.out.println();
        postTravel(integerBiNode);
        System.out.println();
        long search = search(3L, integerBiNode);
        System.out.println(search);
    }

    public static <T> void initialTree(T[] nums,int left,int right,BiNode<T> node){
        if (left>right){
            return ;
        }else{
            int mid=left+right>>1;
            node.data=nums[mid];
            node.left=new BiNode<>();
            node.right=new BiNode<>();
            initialTree(nums,left,mid-1,node.left);
            initialTree(nums,mid+1,right,node.right);
        }
    }

    /**
     * 广度优先遍历
     * @param root
     * @param <T>
     */
    public static <T> void travelTree(BiNode<T> root){
        if (root==null){
            return;
        }
        LinkedList<BiNode<T>>queues=new LinkedList<>();
        queues.add(root);
        int count=1;
        while (!queues.isEmpty()){
            int nextCount=0;
            for (int i = 0; i < count; i++) {
                BiNode<T> poll = queues.poll();
                System.out.print(poll.data+" ");
                if (poll.left.data!=null){
                    queues.add(poll.left);
                    nextCount++;
                }
                if (poll.right.data!=null){
                    queues.add(poll.right);
                    nextCount++;
                }
            }
            System.out.println();
            count=nextCount;
        }
    }

    /**
     * 深度优先遍历-前序遍历
     * @param <T>
     */
    public static <T> void preTravel(BiNode<T> root){
        if (root==null){
            return;
        }
        if (root.data!=null){
            System.out.print(root.data+" ");
        }
        preTravel(root.left);
        preTravel(root.right);
    }
    /**
     * 深度优先遍历-中序遍历
     * @param <T>
     */
    public static <T> void inTravel(BiNode<T> root){
        if (root==null){
            return;
        }
        preTravel(root.left);
        if (root.data!=null){
            System.out.print(root.data+" ");
        }
        preTravel(root.right);
    }

    /**
     * 深度优先遍历-后序遍历
     * @param <T>
     */
    public static <T> void postTravel(BiNode<T> root){
        if (root==null){
            return;
        }
        postTravel(root.left);
        postTravel(root.right);
        if (root.data!=null){
            System.out.print(root.data+" ");
        }
    }

    public static <T> T search(Long target,BiNode<T> node) throws Exception {
        if (node==null){
            return null;
        }
        if (!(node.data instanceof Number)){
            throw new Exception();
        }
        long data = (long) node.data;
        if (data>target){
            search(target,node.right);
        }else if (data<target){
            search(target,node.left);
        }else{
            return node.data;
        }
        return null;
    }


    public static class BiNode<T>  {
        T data;
        BiNode<T> left;
        BiNode<T> right;
        int height;

        BiNode() {

        }
        BiNode(T data) {
            this.data = data;
            this.height = 1;
        }


    }
}
