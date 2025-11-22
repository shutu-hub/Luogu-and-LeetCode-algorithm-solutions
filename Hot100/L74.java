package Hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L74 {

    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,1,5,6,4},2);
    }

    public static int findKthLargest(int[] nums, int k) {
        // 维护一个K大小的小顶堆，头元素在堆中最小，在数组元素中第K大
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
        for (int i = 0; i < k; i++) {
           // 先添加k个元素，确保堆达到最大容量
            minQueue.offer(nums[i]);
        }
        for (int i = k; i <nums.length ; i++) {
            if (nums[i]>minQueue.peek()){
                // 大于堆顶元素，入栈
                minQueue.poll();
                minQueue.offer(nums[i]);
            }
        }
        return minQueue.peek();
    }
}
