package Hot100;

import java.util.HashMap;

public class L1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                // 可以组成组合
                // 不能两次使用相同的元素
                if (i!=map.get(target-nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
            }
        }
        return new int[]{};
    }
}
