package BinarySearch;
import java.util.*;


public class P2678 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int l = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[]array=new int[n+2];
        int max=-1;
        for (int i = 1; i <= n; i++) {
            array[i]= scanner.nextInt();
            if (array[i]>max){
                max=array[i];
            }
        }
        array[n+1]=l;
        int left=1;int right=max;
        if (n==0){
            System.out.println(l);
        }else{
            while(left<=right){
                int mid=(left+right)>>1;
                int count=0;
                int before=0;
                for (int i = 1; i <n+2 ; i++) {
                    if (array[i]-array[before]<mid){
                        count++;
                    }else{
                        before=i;
                    }
                }
                if (count<=m){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            System.out.println(left-1);
        }
    }
}
