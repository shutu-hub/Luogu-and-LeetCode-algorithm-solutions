package Hot100;
import java.util.HashSet;
import java.util.Set;

public class L3 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength=0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            // 从当前数开始向后找
            int currentNum = num;
            int currentLength = 1;
            // 在while循环中不是每次都遍历n个元素 而是每个元素只会被处理一次
            while (set.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }
            maxLength = Math.max(currentLength, maxLength);
        }
        return maxLength;
    }
}
