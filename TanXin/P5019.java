package TanXin;

import java.util.Arrays;
import java.util.Scanner;

public class P5019 {
    public static int day=0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[]array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextInt();
        }
        fenzhi(array,0,array.length-1);
        System.out.println(day);
    }
    /**
     * 4 3 2 5 3 5
     * 2 1 0 3 1 3
     * 1 0 0 3 1 3
     * 0 0 0 3 1 3
     * 0 0 0 2 0 2
     * 0 0 0
     * @param array
     * @param left
     * @param right
     */
    public static void fenzhi(int[] array,int left,int right) {
        if (left>right){
            return;
        }
        int min=Integer.MAX_VALUE;
        int index=-1;
        for (int i = left; i <=right ; i++) {
            if (array[i]<min){
                min=array[i];
                index=i;
            }
        }
        for (int i = left; i <=right ; i++) {
            array[i]-=min;
        }
        day+=min;
        fenzhi(array,left,index-1);
        fenzhi(array,index+1,right);
    }


}
