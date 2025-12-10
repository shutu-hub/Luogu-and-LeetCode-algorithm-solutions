package Hot100;

import java.util.HashMap;

public class L1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int search=target-nums[i];
            if (map.containsKey(search)){
                if (i!=map.get(search)){
                    return new int[]{i,map.get(search)};
                }
            }
        }
        return new int[]{};
    }
}
