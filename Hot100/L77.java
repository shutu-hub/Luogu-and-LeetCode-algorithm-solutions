package Hot100;

public class L77 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]< min){
                min=prices[i];
            }else{
                // 大于最小值，则尝试更新最大利润
                max=Math.max(max, prices[i]-min);
            }
        }
        return Math.max(max, 0);
    }
}
