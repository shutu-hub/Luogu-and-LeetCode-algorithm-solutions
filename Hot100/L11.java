package Hot100;

import java.util.Arrays;
import java.util.LinkedList;

public class L11 {

    public static void main(String[] args) {
        int[] nums = {1};
        int[] ints = maxSlidingWindow(nums, 1);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 1 创建固定区间的窗口,存储元素下标
        LinkedList<Integer> window = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        int index = 0;
        for (int right = 0; right < nums.length; right++) {
             while (window.peekLast()!=null && nums[right]>=nums[window.peekLast()]){
                    window.pollLast();
             }
             window.offer(right);
             while (window.peekFirst()!=null && right-window.peekFirst()>=k){
                 window.pollFirst();
             }
             if (right>=k-1){
                 result[index++]=nums[window.peekFirst()];
             }
        }
        return result;
    }
}
