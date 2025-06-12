package Hot100;

public class L7 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
       int sum=0;
       int left=0,right=height.length-1;
       int leftMax=0,rightMax=0;
       while(left<right){
           leftMax=Math.max(leftMax,height[left]);
           rightMax=Math.max(rightMax,height[right]);
           if (height[left]<=height[right]){
               // 左边柱子高度小于右边柱子高度 这个柱子的蓄水量受左柱子影响 长为1 高度为左柱子 - 当前柱子、
               // 每次计算柱子高度小的一侧 所以右边有比leftMax更高的柱子 所以leftMax-height[left]就是高
               sum+=leftMax-height[left];
               left++;
           }else{
               sum+=rightMax-height[right];
               right--;
           }
       }
       return sum;
    }
}
