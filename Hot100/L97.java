package Hot100;

import java.util.HashMap;
import java.util.Map;

public class L97 {

    public int majorityElement(int[] nums) {
        // 找到nums数组中元素个数 > n/2
        int target = nums.length/2;
        // 最多只能有一个元素的个数 > n/2,找到元素最多的个数，输出
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value>target){
                return entry.getKey();
            }
        }
        return -1;
    }


}
