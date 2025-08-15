package review;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Iterator;

public class P3799 {
	public static void main(String[] args) throws IOException {
		StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int n=(int)st.nval;
		int[]num=new int[5*1000+1];
		for (int i = 0; i < n; i++) {
			st.nextToken();
			num[(int)st.nval]++;
		}
		long mod=(long)(1e9+7);
		long count=0;
		for (int i = 2; i < num.length; i++) {
			if (num[i]<2) {
				continue;
			}
			// 在num[i]个数中选2个
			long one=num[i]*(num[i]-1)/2;
			// 在组合时j<=i/2 避免重复计算组合 如 1，2计算完之后再次计算2，1
			for (int j = 1; j <= i/2; j++) {
				long two=0;
				if (i-j==j && num[j]>=2) {
					// 在长度等于j的数中选两个
					 two=num[j]*(num[j]-1)/2;
				}else if (i-j!=j && num[j]>=1 && num[i-j]>=1 ) {
					 two=num[j]*num[i-j];
				}
				count+=one*two;
				count%=mod;
			}
		}
		System.out.println(count);
	}
	
}
