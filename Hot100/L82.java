package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L82 {
    public static void main(String[] args) {
        L82 l82 = new L82();
        List<List<Integer>> lists = l82.generate(5);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print( integer+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        // numRow行，numRow行+1列
        int[][] dp = new int[numRows+1][numRows+1];
        dp[1][1]=1;
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows==1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            lists.add(list);
            return lists;
        }
        for (int i = 2; i <= numRows; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i ; j++) {
                list.add(dp[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }
}
