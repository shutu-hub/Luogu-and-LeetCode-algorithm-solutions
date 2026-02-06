package Hot100;

import java.util.*;

/**
 * HOT100-6:三数之和
 * 本题暴力写法是三重循环找到符号条件的 i,j和k,然后再去重，时间复杂度为三次方
 * 对数组进行排序，采用双指针策略，将第二层循环和第三层循环处在一层，时间复杂度可降低为二次方
 * 在一层循环中通过 l和r变量寻找符合元素，通过判断相邻元素是否相等实现去重
 */
public class L6 {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // -4 -1 -1 0 1 2
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
       // nums[l]+nums[r]=-nums[i]
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
