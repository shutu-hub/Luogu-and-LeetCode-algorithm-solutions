package Hot100;


/**
 * HOT100-7:接雨水
 * 解题思路：
 *  双指针策略，我们依次计算每个柱子的蓄水量，然后累加即可得出总蓄水量，每个柱子的蓄水量取决于两侧最大高度相对较低的那一个，
 *  当左侧最大高度较低时，蓄水高度是由左侧柱子的高度决定，当前柱子和左侧最大高度的差值就是当前柱子的蓄水量
 *  当右侧最大高度较低时，蓄水高度是由右侧柱子的高度决定，当前柱子和右侧最大高度的差值就是当前柱子的蓄水量
 */
public class L7 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
       int sum=0;
       int left=0,right=height.length-1;
       int leftMax=height[0],rightMax=height[right];
       while (left<right){
           if (leftMax<=rightMax){
               left++;
               if (height[left]<leftMax){
                   sum+=leftMax-height[left];
               }else {
                   leftMax=height[left];
               }
           }else{
               right--;
               if (height[right]<rightMax){
                   sum+=rightMax-height[right];
               }else{
                   rightMax=height[right];
               }
           }
       }
       return sum;
    }
}
