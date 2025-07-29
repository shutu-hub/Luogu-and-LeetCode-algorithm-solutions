package Hot100;

import java.util.HashSet;

public class L3 {

    public int longestConsecutive(int[] nums) {
        // 使用HashSet存储所有数，用来判断该数是否存在
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen=0;
        // 细节：遍历set中的元素会比遍历nums中的元素少
        for (int current : set) {
            if (set.contains(current - 1)) {
                continue;
            }
            int len = 1;
            int search = current + 1;
            while (set.contains(search)) {
                len++;
                search++;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
