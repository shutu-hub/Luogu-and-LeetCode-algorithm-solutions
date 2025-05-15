package RuMen;

public class lintCode532 {

    static long sum;

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{}));
    }

    /**
     * @param a: an array
     * @return: total of reverse pairs
     */
  public static long reversePairs(int[] a) {
            mergeSort(a,0, a.length-1);
            return sum;
  }

    public static void mergeSort(int[]nums,int l,int r){
        // 递归出口
        if (l>=r){
            return;
        }
        int mid=(l+r)>>1;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        // 对 L-R区间排序
        int[]tempArrays=new int[r-l+1];
        int index=0;
        int l1=l;
        int l2=mid+1;
        // 当左区间和右区间都有元素时 每次选出较小的放入临时数组
        while(l1<=mid && l2<=r){
            if (nums[l1]<=nums[l2]){
                tempArrays[index]=nums[l1];
                index++;
                l1++;
            }else{
                // 累计逆序对
                sum+=mid-index+1;
                tempArrays[index]=nums[l2];
                index++;
                l2++;
            }
        }
        while (l1<=mid){
            tempArrays[index]=nums[l1];
            index++;
            l1++;
        }
        while (l2<=r){
            tempArrays[index]=nums[l2];
            index++;
            l2++;
        }
        for (int i = 0; i <tempArrays.length ; i++) {
            nums[l+i]=tempArrays[i];
        }
    }
}