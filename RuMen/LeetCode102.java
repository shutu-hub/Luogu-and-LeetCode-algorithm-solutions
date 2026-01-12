package RuMen;

public class LeetCode102 {

    static int count=0;

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        count=0;
        dfs(1,nums,target,sum);
        return count;
    }

    public static void dfs(int index,int[]nums,int target,int sum){
        if(index>nums.length){
            if(sum==target){
                count++;
            }
            return;
        }
        dfs(index+1,nums,target,sum+nums[index-1]);
        dfs(index+1,nums,target,sum-nums[index-1]);
    }
}
