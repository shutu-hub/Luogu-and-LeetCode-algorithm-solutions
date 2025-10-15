package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L55 {

    List<List<Integer>> lists;

    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<>();
        boolean[]flags = new boolean[nums.length];
        digui(nums,1,flags,new ArrayList<>());
        return lists;
    }

    private void digui(int[] nums, int index, boolean[]flags,List<Integer> list) {
        if (index>nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]){
                flags[i] = true;
                list.add(nums[i]);
                digui(nums,index+1,flags,list);
                list.remove(index-1);
                flags[i] = false;
            }
        }
    }
}
