package Hot100;

public class L10 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int count=0;
        int[]prefixSum=new int[nums.length];
        prefixSum[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        for (int end = 0; end < nums.length; end++) {
            for (int start = 0; start <= end; start++) {
                int sum=prefixSum[end]-prefixSum[start]+nums[start];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}
