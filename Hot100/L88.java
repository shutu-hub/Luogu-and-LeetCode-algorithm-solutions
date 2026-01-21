package Hot100;

public class L88 {

    /**
     * 将nums数组分割为两个等大的数组
     * 解题思路：
     * 可以使用0-1背包的思想，如果能将背包放满总和的一半，那么刚好能够将数组切分为等大的两个数组
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums.length<2){
            // 只能有一个数组
            return false;
        }
        // 和是奇数也无法拆分
        int sum=0;
        int maxNum=0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(num, maxNum);
        }
        if (sum%2!=0){
            return false;
        }
        if (maxNum>sum/2){
            // 如果最大值大于和的一半，则无法切非
            return false;
        }
        // 0-1背包
        int target=sum/2;
        boolean[][]dp = new boolean[nums.length][target+1];// 从nums中第0个数到第i个数中选取数字，使其等于j
        // 当不选取任何数字时，正整数为0
        for (int i = 0; i < nums.length+1; i++) {
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;//在第一个数字时，nums[0]可以凑齐其本身，其余都小于本身
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 1; j <= target ; j++) {
                if (j>=nums[i]){
                    dp[i][j]=dp[i-1][j] | dp[i-1][j-num];// 选该数，则需要凑齐的是j-num值
                }else{
                    // 和小于当前数,则本轮当前数不能选
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
