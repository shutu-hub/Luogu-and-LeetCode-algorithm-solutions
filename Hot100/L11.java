package Hot100;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * HOT100-11:滑动窗口的最大值
 */
public class L11 {

    public static void main(String[] args) {
        int[] nums = {3,1,1,3};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    // 1 3 2 5 6
    // 单调递减的队列，头部元素最大，尾部元素最小
    // 插入元素时应保证单调性，插入元素要小于尾部元素
    public static int[] maxSlidingWindow(int[] nums, int k) {
       LinkedList<Integer> queue = new LinkedList<>();
       int[] res = new int[nums.length-k+1];
       int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 注意这里比较的是值
            while (!queue.isEmpty() && nums[queue.peekLast()]<nums[right]){
                queue.pollLast();
            }
            // 将新元素插入到队列
            queue.offerLast(right);
            // 判断头部有效性
            while (queue.peekFirst()<=right-k){
                queue.pollFirst();
            }
            // 记录窗口最大值
            if (right>=k-1){
                res[left]=nums[queue.peekFirst()];
                left++;
            }
        }
        return res;
    }
}
