package review.P15;

import java.util.Scanner;

public class five {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		double p=scanner.nextDouble();
		int resultCount=Integer.MAX_VALUE;
		int resultK=Integer.MAX_VALUE;
		for (int k = 1; k <= n; k++) {
			int count=0;
			if (n%k==0) {
				count+=n/k;
				double ganran=1-Math.pow(1-p, k);
				int count_tmp=(int) ((n/k)*ganran*k);
				count+=count_tmp;
				if (count<resultCount) {
					resultCount=count;
					resultK=k;
				}
			}
		}
		System.out.println(resultK);
	}
}
