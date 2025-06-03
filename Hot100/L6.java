package Hot100;

import java.util.*;

public class L6 {
    public static void main(String[] args) {
    }

    public static List<List<Integer>> threeSum(int[] nums) {
       // i l r nums[l]+nums[r]=-nums[i]
        List<List<Integer>> lists = new ArrayList<>();
       Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1]){
                // 这个数和前边一个数重复 则会导致出现相同的组合 跳过
                continue;
            }
            int l=i+1;int r=nums.length-1;
            // i < l < r
            while(l<r){
                if (nums[l]+nums[r]==-nums[i]){
                    lists.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    // 跳过重复的数
                    while(l<r && nums[l]==nums[l-1])l++;
                    while(l<r && nums[r]==nums[r+1])r--;
                }else if (nums[l]+nums[r]<-nums[i]){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return lists;
    }
}
