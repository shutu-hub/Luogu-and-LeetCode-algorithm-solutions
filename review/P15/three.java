package review.P15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class three {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		HashMap<Integer, ArrayList<Integer>>map=new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		while(scanner.hasNext()) {
			String option=scanner.next();
			if (option.equals("add")) {
				int num=scanner.nextInt();
				map.get(1).add(num);
			}else if (option.equals("sync")) {
				int id=scanner.nextInt();
				ArrayList<Integer> list=map.get(id+1);
				if (list.size()<map.get(1).size()) {
					list.add(map.get(1).get(list.size()));
				}
			}else {
				// 找到元素最少的那个
				int minSize=Integer.MAX_VALUE;
				for (int i = 1; i <= n; i++) {
					if (map.get(i).size()<minSize) {
						minSize=map.get(i).size();
					}
				}
				System.out.println(minSize);
			}
		}
	}
}
