package Hot100;

public class L10 {
    public static void main(String[] args) {

    }

    // -1 -1 1
    // -1 -2 -1
    public int subarraySum(int[] nums, int k) {
        // 找到数组中和为 k 的子数组
        // nums.length在1e4级别，时间复杂度最高为O(n2)
        int[] prefixSum= new int[nums.length];
        prefixSum[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        int sum=0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                if (prefixSum[right]-prefixSum[left]+nums[left]==k){
                    sum++;
                }
            }
        }
        return sum;
    }
}
