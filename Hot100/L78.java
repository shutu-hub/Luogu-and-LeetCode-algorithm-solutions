package Hot100;

public class L78 {

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i>maxIndex){
                // 当前点大于之前能到达的最远的点,该点到达不了
                return false;
            }
            // 更新能到达的最远位置（注意:该点能到达的最远位置之前的点，均可以通过减小步幅来到达）
            maxIndex = Math.max(maxIndex,i+nums[i]);
        }
        return true;
    }
}
