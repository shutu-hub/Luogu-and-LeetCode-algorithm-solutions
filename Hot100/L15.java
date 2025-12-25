package Hot100;


public class L15 {

    public static void main(String[] args) {
        rotate(new int[]{-1},2);
    }

    /**
     * nums中元素向右移动k个位置
     * 向右移动k个位置，在移动过程中可能超出数组长度，mod数组长度，就可以保证数组索引都在范围内
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int[]newArray=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index =(i+k)%nums.length;
            newArray[index]=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=newArray[i];
        }
    }
}
