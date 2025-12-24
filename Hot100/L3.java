package Hot100;

import java.util.HashSet;

public class L3 {

    /**
     * 解题思路：
     * 判断一个元素的最长连续序列，就是从当前数字开始去找比它大的数字，每次差值为1，如果找到了就len++，每次记录当前的最大值
     * 优化点：如果当前数存在比他小1的数，则跳过，因为比他小1的数和它是连续的，它计算出来的最大连续序列肯定比当前数大1
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (Integer current : set) {
            if (set.contains(current-1)){
                continue;
            }
            // 从当前数开始向后找
            int len=1;
            int search=current+1;
            maxLen=Math.max(maxLen,len);
            while (set.contains(search)){
                len++;
                search++;
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}
