package SouSuo;

public class LeetCode102 {

    static int count;

    public int findTargetSumWays(int[] nums, int target) {
            count=0;
            dfs(nums,target,0,0);
            return count;
    }

    public static void dfs(int[] nums, int target, int sum,int index){
        if (index>=nums.length){
            if (sum==target){
                count++;
            }
            return;
        }
        // 在该数前加+
        int add = nums[index];
        sum+=add;
        dfs(nums,target,sum,index+1);
        sum-=add;
        // 在该数前加-
        int sub = -nums[index];
        sum+=sub;
        dfs(nums,target,sum,index+1);
        sum-=sub;
    }

}
