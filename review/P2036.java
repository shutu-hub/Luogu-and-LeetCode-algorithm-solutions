package review;

import java.util.Scanner;



public class P2036 {
	public static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[][]array=new int[n+1][2];
		for (int i = 1; i <= n; i++) {
			// 酸度
			array[i][0]=scanner.nextInt();
			// 苦度
			array[i][1]=scanner.nextInt();
		}
		dfs(array,1,0,1);
		System.out.println(min);
	}
	
	public static void dfs(int[][]array,int s,int b,int index) {
		if (index>=array.length) {
			if (s==1 && b==0) {
				// 没有选择一种配料 则不能计算min值 否则会把min值更新为1
				return;
			}
			min=Math.min(Math.abs(s-b), min);
			return;
		}
		dfs(array, array[index][0]*s, array[index][1]+b, index+1);
		dfs(array, s, b, index+1);
	}
}
