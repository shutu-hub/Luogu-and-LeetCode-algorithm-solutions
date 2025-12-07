package Hot100;

import java.util.HashSet;
import java.util.Set;

public class L96 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        int res = 0;
        for (Integer integer : set) {
            res = integer;
        }
        return res;
    }
}
