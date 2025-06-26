package RuMen;

public class LintCode532 {

    long sum=0;

    /**
     * @param a: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] a) {
        sum=0;
        mergeSort(a,0,a.length-1);
        return sum;
    }

    public  void mergeSort(int[]a,int left,int right){
        // 对left-right区间归并排序
        if(left>=right){
            return;
        }
        int mid=(left+right)>>1;
        mergeSort(a,left,mid);
        mergeSort(a,mid+1,right);
        merge(a,left,mid,right);
    }

    public  void merge(int[]a,int left,int mid,int right){
        // 对左右已经排好序的区间合并
        int[]tempArray=new int[right-left+1];
        // 每次选出较小者加入临时数组
        int l=left;
        int r=mid+1;
        int k=0;

        while(l<=mid && r<=right){
            if(a[l]<=a[r]){
                tempArray[k]=a[l];
                l++;
                k++;
            }else{
                // 左边元素大于右边元素 产生逆序对
                tempArray[k]=a[r];
                sum+=mid-l+1;
                r++;
                k++;
            }
        }
        while(l<=mid){
            tempArray[k]=a[l];
            k++;
            l++;
        }
        while(r<=right){
            tempArray[k]=a[r];
            k++;
            r++;
        }
        int index=left;
        for (int j : tempArray) {
            a[index] = j;
            index++;
        }
    }
}