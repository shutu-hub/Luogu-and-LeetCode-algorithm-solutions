package Hot100;

import java.util.*;

/**
 * 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class L75 {
    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        for (int ele : ints) {
            System.out.print(ele+" ");
        }
    }

    /**
     * 堆删除指定元素，只会返回 boolean，不能返回元素本身
     * 所以在这里需要提前构建出元素出现次数
     * nums中存在负数，无法通过值映射的方式构建，需要用 map
     * 题目中要求时间复杂度 必须 优于 O(n log n)，那么则不能将所有元素放入堆中，而是在堆的个数达到k时，只改变头元素，时间复杂度为
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 这里应该用小顶堆，堆顶元素的频率值最小
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 这里最坏情况下所有元素都不同，外层循环为n，内层堆操作为 O(log k) ，O(n log k)
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            if (queue.size()==k){
                if (queue.peek()[1]<count){
                    // 堆顶频率值小，删除堆顶元素
                    queue.poll();
                    queue.offer(new int[]{key,count});
                }
            }else{
                queue.offer(new int[]{key,count});
            }
        }
       int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=queue.poll()[0];
        }
        return res;
    }
}
