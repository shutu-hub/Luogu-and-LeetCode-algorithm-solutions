package review.P15;

import java.util.Scanner;

public class four {
	public static void main(String[] args) {
		// 桌子要尽可能的坐满 或坐的人数更多
		Scanner scanner=new Scanner(System.in);
		int q=scanner.nextInt();
		for (int i = 0; i < q; i++) {
			int a2=scanner.nextInt();
			int a3=scanner.nextInt();
			int a4=scanner.nextInt();
			int b4=scanner.nextInt();
			int b6=scanner.nextInt();
			
			// 先坐四人桌
			long sum=0;
			// 一个四人寝
			while (b4>0 && a4>0) {
					b4--;
					a4--;
					sum+=4;
			}			
			// 两个两人寝
			while (b4>0 && a2>=2) {
				b4--;
				a2-=2;
				sum+=4;
			}
			// 一个三人寝坐
			while (b4>0 && a3>0) {
				b4--;
				a3--;
				sum+=3;
			}
			// 一个二人寝坐
			while (b4>0 && a2>0) {
				b4--;
				a2--;
				sum+=2;
			}
			// 一个四人寝和一个二人寝
			while (b6>0 && a4>0 &&a2>0) {
				b6--;
				a4--;
				a2--;
				sum+=6;
			}
			// 三个两人寝坐六人桌
			while(b6>0 && a2>=3) {
				b6--;
				a2-=3;
				sum+=6;
			}
			//两个三人寝坐六人桌
			while (b6>0 && a3>=2) {
				b6--;
				a3-=2;
				sum+=6;
			}
			while (b6>0 && a3>0 &&a2>0) {
				b6--;
				a3--;
				a2--;
				sum+=5;
			}
			while (b6>0 && a4>0) {
				b6--;
				a4--;
				sum+=4;
			}
			while (b6>0 && a2>=2) {
				b6--;
				a2-=2;
				sum+=4;
			}
			while (b6>0 && a3>0) {
				b6--;
				a3--;
				sum+=3;
			}
			while (b6>0 && a2>0) {
				b6--;
				a2--;
				sum+=2;
			}
			System.out.println(sum);
		}
	}
}
