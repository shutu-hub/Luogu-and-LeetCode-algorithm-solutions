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
        // nums[i]+nums[j]=-nums[k]
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1]){
                // 这个数和之前的数重复，跳过
                continue;
            }
            // nums[i]确定，寻找nums[j]和nums[k],nums[j]+nums[k]=-nums[i]
            int j =i+1,k=nums.length-1;
            while (j<k){
                if (nums[j]+nums[k]==-nums[i]){
                    lists.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;//数增大
                    k--;//数减小
                    while (j<k && nums[j]==nums[j-1])j++;
                    while (j<k && nums[k]==nums[k+1])k--;
                }else if (nums[j]+nums[k]<-nums[i]){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return lists;
    }
}
