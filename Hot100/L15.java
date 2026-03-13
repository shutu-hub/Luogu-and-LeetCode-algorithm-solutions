package Hot100;



/**
 * HOT100-15:轮转数组
 */
public class L15 {

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }


    /**
     * 翻转数组
     */
    public static void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void reverse(int[]nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }



    /**
     * 方法一:创建一个数组复制
     * nums中元素向右移动k个位置
     * 向右移动k个位置，在移动过程中可能超出数组长度，mod数组长度，就可以保证数组索引都在范围内
     * @param nums
     * @param k
     */
//    public static void rotate(int[] nums, int k) {
//        int[]res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int newIndex = (i + k) % nums.length;
//            res[newIndex]=nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i]=res[i];
//        }
//        System.out.println(Arrays.toString(nums));
//    }
}
