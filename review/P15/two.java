package review.P15;

import java.util.Arrays;

public class two {
	public static void main(String[] args) {
		boolean flag=false;
		for (int i = 10000000; i >=0;i--) {
			// 找到i的每一位 然后初始化数组
			String num=i+"";
			long[]dp=new long[num.length()];
			for (int j = 0; j < num.length(); j++) {
				dp[j]=num.charAt(j)-'0';
			}
			// 不断迭代下一位 直到找到n或者值大于n
			int index=0;
			while (true) {
				long sum=0;
				for (int j = 0; j < dp.length; j++) {
					sum+=dp[j];
				}
				if(sum==i) {
					System.out.println(i);
					flag=true;
					break;
				}
				if(sum>i) {
					break;
				}
				dp[index%num.length()]=sum;
				index++;
			}
			if (flag) {
				break;
			}
		}
	}
}
