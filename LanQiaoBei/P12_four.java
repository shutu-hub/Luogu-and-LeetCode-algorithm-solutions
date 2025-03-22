package LanQiaoBei;
import java.util.ArrayList;


public class P12_four {
    public static void main(String[] args) {
        long n=2021041820210418L;
        // 找到n的所有因子
        ArrayList<Long>arrayList=new ArrayList<>();
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n%i==0){
                arrayList.add(i);
                if (i!=n/i){
                    arrayList.add(n/i);
                }
            }
        }
        long sum=0;
        int size = arrayList.size();
        for (Long aLong : arrayList) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (aLong * arrayList.get(j) * arrayList.get(k) == n) {
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
